package com.wfteamlab.engineering.product.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfteamlab.engineering.product.dao.ProductDAO;
import com.wfteamlab.engineering.product.vo.Product;

@Service("ProductService")
public class ProductService implements IProductService{
	
	@Autowired
	ProductDAO dao;
	
	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		
		int result = 0;
		//logger.info("회원가입 DAO 시작");
		try{
			result = dao.insertProduct(product);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<Product> showList() {
		ArrayList<Product> productList = null;
		try{
			productList = dao.showList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return productList;
	}


}
