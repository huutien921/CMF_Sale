package com.cmf.sale.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmf.sale.entities.Product;
import com.cmf.sale.repositories.ProductRepository;

@Service
public class ProductServiceImp implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	@Override
	public Iterable<Product> findAll() {
		
		return productRepository.findAll();
	}

	@Override
	public Product findById(int idProduct) {
	
		return productRepository.findById(idProduct).get();
	}

	@Override
	public Product save(Product product) {

		return productRepository.save(product);
	}
	

}
