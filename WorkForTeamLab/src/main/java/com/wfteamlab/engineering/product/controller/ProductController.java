package com.wfteamlab.engineering.product.controller;

//import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.wfteamlab.engineering.common.util.FileService;
import com.wfteamlab.engineering.product.dao.ProductDAO;
//import com.wfteamlab.engineering.product.service.ProductService;
import com.wfteamlab.engineering.product.vo.Product;


@RequestMapping(value="product")
@Controller
public class ProductController {
	
	@Autowired
	ProductDAO dao;
	/*@Resource(name="productService")
    private ProductService productService;*/
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	final String uploadPath = "/productfile";
	
	@RequestMapping(value="/goSellPage", method=RequestMethod.GET)
	public String goSellPage(){
		logger.info("goSell 이동 시작");
		logger.info("goSell 이동 종료");
		return "product/sellPage";
	}
	
	@RequestMapping(value="/SellProduct", method=RequestMethod.POST)
	public String sellProduct(Product product, MultipartFile upload){
		logger.info("글 작성 시작");
		int result = 0;
		
		//upload파일이 있을 경우. (즉, 파일을 첨부 했을 때에만 해주어야 한다.)
		if(!upload.isEmpty() || upload != null){
			
		//실제로 파일을 저장할 경로에 파일을 저장해야 함. (지금은 parameter로 전달만 받은 상태)
		String savedfilename = FileService.saveFile(upload, uploadPath);
		
		product.setProd_savedfile(savedfilename);
		product.setProd_originalfile(upload.getOriginalFilename());
			
		}
		
		result = dao.insertProduct(product);
		
		if(result != 1){
			logger.info("not inserted");
			return "product/sellPage";
		}
		logger.info("insertProduct complete");
		
		return "redirect:/"; 
	}
	
	/*
		if(result != 1){
			logger.info("글 작성 종료지만 오류나서 다시 write폼으로");
			return"board/writeForm";
		}
		logger.info("글 작성 종료");
		return "redirect:list"; //requestMapping이 list인 곳을 찾는다.
		
	}
	 * */
	
}
