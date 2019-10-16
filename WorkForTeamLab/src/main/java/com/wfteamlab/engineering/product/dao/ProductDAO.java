package com.wfteamlab.engineering.product.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wfteamlab.engineering.product.vo.Product;

@Repository
public class ProductDAO {
	
private static final Logger logger = LoggerFactory.getLogger(ProductDAO.class);

	@Autowired
	SqlSession sqlsession;

	
	//ユーザーが登録した商品内容をDB上に登録
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		int result = 0;
		ProductMapper mapper = sqlsession.getMapper(ProductMapper.class);
		try{
			result = mapper.insertProduct(product);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	//登録されている商品を全て取得する
	public ArrayList<Product> showList() {
		// TODO Auto-generated method stub
		ProductMapper mapper = sqlsession.getMapper(ProductMapper.class);

		ArrayList<Product> productList = null;
		try{
			productList = mapper.showList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return productList;
	}
	
	//商品詳細ページにて必要な商品の詳細情報を取得する
	public Product selectProdOne(int prod_num) {
		// TODO Auto-generated method stub
		ProductMapper mapper = sqlsession.getMapper(ProductMapper.class);

		Product product =null;
		try{
		product = mapper.selectProdOne(prod_num);
		}catch(Exception e){
			e.printStackTrace();
		}
		return product;
	}
	
	
	
	
}
