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
	
	//ユーザーが登録した商品内容をDB上に登録
	@Override
	public int insertProduct(Product product) {
		int result = 0;
		try{
			result = dao.insertProduct(product);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	//登録されている商品を全て取得する
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
