package com.wfteamlab.engineering.product.service;

import java.util.ArrayList;

import com.wfteamlab.engineering.product.vo.Product;

public interface IProductService {
	
	int insertProduct (Product product);
	
	ArrayList<Product> showList();
	
}
