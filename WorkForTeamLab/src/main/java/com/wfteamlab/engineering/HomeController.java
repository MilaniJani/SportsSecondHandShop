package com.wfteamlab.engineering;

import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wfteamlab.engineering.product.dao.ProductDAO;
import com.wfteamlab.engineering.product.service.ProductService;
import com.wfteamlab.engineering.product.vo.Product;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ProductDAO dao;
	
	/**
	 * home page. 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		logger.info("welcome home Page");	
		
		//商品のリストをDBから取得して画面に表示する処理
		ArrayList<Product> productList = null;
		productList = dao.showList();
		model.addAttribute("productList", productList);
		return "home";
	}
	
}
