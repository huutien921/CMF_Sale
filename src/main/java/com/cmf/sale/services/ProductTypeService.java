package com.cmf.sale.services;

import com.cmf.sale.entities.ProductType;
import com.google.gson.annotations.Expose;


public interface ProductTypeService {
	public Iterable<ProductType> findAll();
	public ProductType findById(int idType);
}
