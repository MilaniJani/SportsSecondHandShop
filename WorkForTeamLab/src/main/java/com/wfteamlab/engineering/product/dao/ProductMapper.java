package com.wfteamlab.engineering.product.dao;

import java.util.ArrayList;

import com.wfteamlab.engineering.product.vo.Product;

public interface ProductMapper {

	public int insertProduct(Product product);

	public ArrayList<Product> showList();

}
