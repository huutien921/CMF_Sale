package com.cmf.sale.services;

import com.cmf.sale.entities.Product;


public interface ProductService {
	public Iterable<Product> findAll();
	public Product findById(int idProduct);
	public Product save(Product product);
}
