package com.cmf.sale.model.views;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;

import org.modelmapper.ModelMapper;

import com.cmf.sale.entities.InvoiceDetail;
import com.cmf.sale.entities.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.annotations.Expose;

public class ProductResponse {
	@Expose
	private Integer id;
	@Expose
	private String typeName;
	@Expose
	private String name;
	@Expose
	private String image;
	@Expose
	private String description;
	@Expose
	private Integer amount;
	@Expose
	private Integer status;
	@Expose
	private List<InvoiceDetail> invoiceDetails = new ArrayList<InvoiceDetail>();
	public ProductResponse  setProductResponse(Product product) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(product, ProductResponse.class);
	}
	
	public ProductResponse() {
		super();
	}
	

	public ProductResponse(Integer id, String typeName, String name, String image, String description, Integer amount,
			Integer status, List<InvoiceDetail> invoiceDetails) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.name = name;
		this.image = image;
		this.description = description;
		this.amount = amount;
		this.status = status;
		this.invoiceDetails = invoiceDetails;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}





	public String getTypeName() {
		return typeName;
	}

	public void setTypeName1(String typeName) {
		this.typeName = typeName;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<InvoiceDetail> getInvoiceDetails() {
		return invoiceDetails;
	}
	public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
	
	
	
}
