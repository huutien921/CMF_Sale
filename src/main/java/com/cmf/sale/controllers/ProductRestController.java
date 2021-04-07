package com.cmf.sale.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmf.sale.entities.Product;
import com.cmf.sale.entities.ProductType;
import com.cmf.sale.kafka.CFMKafkaService;
import com.cmf.sale.model.api.CMFPageRequest;
import com.cmf.sale.model.api.CMFResponse;
import com.cmf.sale.model.api.ProductResponse;
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
	
//	@Autowired
//	private RedisTemplate template;

	@Autowired
	private CFMKafkaService kafkaService ;
	
	public static final String FIND_ALL = "FIND_ALL";
	public static final long  DEFAULT_REDIS_EXPIRE = 600000;
//	@RequestMapping(value = "/product/findAll", produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
//	public @ResponseBody String findAll(){
//		List<Product> products;
//		products =  (List<Product>) template.opsForValue().get(FIND_ALL.toString());
//		if (products == null) {
//			products = (List<Product>) productService.findAll();
//			template.opsForValue().set(FIND_ALL.toString() ,products,DEFAULT_REDIS_EXPIRE , TimeUnit.SECONDS);
//		}
//		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//		String json = gson.toJson(products);
//		return json;
//	}
	@RequestMapping(value = "/product/kafka", produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public @ResponseBody String sendKafka(){
		List<Product> products = new  ArrayList<Product>();
		products.add(new Product());
//		products =  (List<Product>) template.opsForValue().get(FIND_ALL.toString());
//		if (products == null) {
//			products = (List<Product>) productService.findAll();
//			template.opsForValue().set(FIND_ALL.toString() ,products,DEFAULT_REDIS_EXPIRE , TimeUnit.SECONDS);
//		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(products);
		try {
			kafkaService.sendMessage("KAFKA :" + json);
		} catch (Exception e) {
			System.out.println("log  : " + e);
		}
	
		return json;
	}
	@RequestMapping(value = "/product", produces = MimeTypeUtils.APPLICATION_JSON_VALUE , method = RequestMethod.POST )
	public @ResponseBody String findByPage(@RequestBody CMFPageRequest pageRequest){
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
	//	template.delete(FIND_ALL);
		return "jenkins5";
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
