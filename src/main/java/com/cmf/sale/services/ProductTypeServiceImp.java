package com.cmf.sale.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmf.sale.entities.ProductType;
import com.cmf.sale.repositories.ProductTypeRepository;

@Service
public class ProductTypeServiceImp implements ProductTypeService{
	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Override
	public Iterable<ProductType> findAll() {
		// TODO Auto-generated method stub
		return productTypeRepository.findAll();
	}

	@Override
	public ProductType findById(int idType) {
		// TODO Auto-generated method stub
		return productTypeRepository.findById(idType).get();
	}
	

}
