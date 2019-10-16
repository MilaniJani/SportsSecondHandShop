package com.wfteamlab.engineering.product.dao;

import java.util.ArrayList;

import com.wfteamlab.engineering.product.vo.Product;

public interface ProductMapper {
    //ユーザーが登録した商品内容をDB上に登録
	public int insertProduct(Product product);
	//登録されている商品を全て取得する
	public ArrayList<Product> showList();
	//商品詳細ページにて必要な商品の詳細情報を取得する
	public Product selectProdOne(int prod_num);

}
