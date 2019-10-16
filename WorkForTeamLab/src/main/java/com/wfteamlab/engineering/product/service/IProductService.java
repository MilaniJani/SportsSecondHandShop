package com.wfteamlab.engineering.product.service;

import java.util.ArrayList;

import com.wfteamlab.engineering.product.vo.Product;

public interface IProductService {
	//ユーザーが登録した商品内容をDB上に登録
	int insertProduct (Product product);
	//登録されている商品を全て取得する
	ArrayList<Product> showList();
	
}
