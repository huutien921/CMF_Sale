package com.cmf.sale.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmf.sale.entities.Product;
import com.cmf.sale.entities.ProductType;
import com.cmf.sale.model.views.CMFResponse;
import com.cmf.sale.model.views.ProductResponse;
import com.cmf.sale.services.ProductService;
import com.cmf.sale.services.ProductTypeService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class ProductRestController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductTypeService productTypeService;
	@RequestMapping(value = "/product/findAll", produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public @ResponseBody String findAll(){
		List<Product> products = (List<Product>) productService.findAll();
		List<ProductResponse> responses = new ArrayList<>();
		responses = products.stream().map(product -> new ProductResponse().setProductResponse(product))
				.collect(Collectors.toList());
		CMFResponse<List<ProductResponse>> cmfResponse =  new CMFResponse<>();
		cmfResponse.setObject(responses);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(cmfResponse);
		return json;
	}
	@RequestMapping(value = "/product", produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public @ResponseBody String findByPage(@PathVariable("page") int page , @PathVariable("limit") int limit){
		List<Product> products = (List<Product>) productService.findAll();
		List<ProductResponse> responses = new ArrayList<>();
		responses = products.stream().map(product -> new ProductResponse().setProductResponse(product))
				.collect(Collectors.toList());
		CMFResponse<List<ProductResponse>> cmfResponse =  new CMFResponse<>();
		cmfResponse.setObject(responses);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(cmfResponse);
		return json;
	}
	@RequestMapping(value = "/product/test", produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public @ResponseBody String findBytest(){
		
		return "jenkins";
	}
	@RequestMapping(value = "/product/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public @ResponseBody String findById(@PathVariable("id")int id){
		CMFResponse<ProductResponse> cmfResponse = new CMFResponse<>();
	
		Product product = productService.findById(id);
		ProductResponse productResponse = new ProductResponse().setProductResponse(product);
		
		cmfResponse.setObject(productResponse);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(cmfResponse);
		return json;
	}
	@RequestMapping(value = "/productType/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public @ResponseBody String findProductByType(@PathVariable("id")int id){
		CMFResponse<List<ProductResponse>> cmfResponse = new CMFResponse<>();
		Set<Product> products =   productTypeService.findById(id).getProducts();
		List<ProductResponse> responses = new ArrayList<>();
		responses = products.stream().map(product -> new ProductResponse().setProductResponse(product))
				.collect(Collectors.toList());
		cmfResponse.setObject(responses);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(cmfResponse);
		return json;
	}
}
