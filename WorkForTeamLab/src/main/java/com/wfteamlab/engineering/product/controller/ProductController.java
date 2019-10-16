package com.wfteamlab.engineering.product.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
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
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	final String uploadPath = "/productfile"; //イメージファイルの保存経路設定
	
	//商品の登録ページに移動
	@RequestMapping(value="/goSellPage", method=RequestMethod.GET)
	public String goSellPage(){
		logger.info("商品登録ページ移動start");
		logger.info("商品登録ページ移動end");
		return "product/sellPage";
	}
	//DB上にユーザーが登録した商品をインサートする
	@RequestMapping(value="/SellProduct", method=RequestMethod.POST)
	public String sellProduct(Product product, MultipartFile upload){
		logger.info("insertProduct start");
		int result = 0;
		
		//uploadファイルがあるかどうか確認
		if(!upload.isEmpty() || upload != null){
			
		//実際にファイルを保存する経路に保存
		String savedfilename = FileService.saveFile(upload, uploadPath);
		//ファイルの経路値をVOにセットする
		product.setProd_savedfile(savedfilename);
		product.setProd_originalfile(upload.getOriginalFilename());
		}
		//DBへ商品を保存する
		result = dao.insertProduct(product);
		
		//DB上に保存失敗した場合、sellPageに戻る
		if(result != 1){
			logger.info("not inserted");
			return "product/sellPage";
		}
		logger.info("insertProduct complete");
		
		//DB上に保存失敗した場合のみ、ホームに移動
		return "redirect:/"; 
	}
	
	
	//商品の詳細ページに移動する
	@RequestMapping(value="/goPdView", method=RequestMethod.GET)
	public String goPdView(String pdNum, Model model){
		logger.info("商品の詳細ページ移動 start");
		int prodNum = Integer.parseInt(pdNum);
		//ユーザーが選択した商品の詳細情報取得
		Product pd = dao.selectProdOne(prodNum); 
		model.addAttribute("vo", pd);
		
		logger.info("商品の詳細ページ移動 end");
		return "product/productView";
	}
	
	
	//ファイル関連処理
		@RequestMapping(value="download", method=RequestMethod.GET)
		public void download(int pdNum, Product product, HttpServletResponse response
				,HttpSession session){
			logger.info("File download start");
			product = dao.selectProdOne(pdNum); 
			//元のファイル名
			String originalFileName = product.getProd_originalfile();
			
			//responseの Headerにファイル名インコ―ディンして登録
			try{
				response.setHeader("Content-Disposition", "attachment;filename="
						+URLEncoder.encode(originalFileName, "UTF-8"));
			}catch(UnsupportedEncodingException e){
				e.printStackTrace();
			}
			
			//ファイルの保存先経路
			String fullPath = uploadPath+"/"+product.getProd_savedfile(); 
			
			//サーバにファイルを読むstreamとクライアントに出力するstreamが必要
			FileInputStream fis = null;
			ServletOutputStream sos = null; //Servletを通じて出力するStream
			
			//ファイルをinputStreamから読んで、outputStreamにコピー
			try{
				fis = new FileInputStream(fullPath);
				sos = response.getOutputStream(); 
				FileCopyUtils.copy(fis, sos); 
				fis.close();
				sos.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			logger.info("File download end");
		}
	
	
	
	
}
