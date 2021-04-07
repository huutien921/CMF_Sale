package com.cmf.sale.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cmf.sale.entities.ProductType;

//@Repository("productTypeRepository")
public interface ProductTypeRepository extends CrudRepository<ProductType, Integer> {
	
	
}
