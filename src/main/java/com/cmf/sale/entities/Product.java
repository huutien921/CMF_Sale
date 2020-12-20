package com.cmf.sale.entities;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;


@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {
	@Expose
	private Integer id;
	@Expose
	private ProductType productType;
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
	private Set<InvoiceDetail> invoiceDetails = new HashSet<InvoiceDetail>(0);

	public Product() {
	}

	public Product(ProductType productType, String name, String image, String description, Integer amount,
			Integer status, Set<InvoiceDetail> invoiceDetails) {
		this.productType = productType;
		this.name = name;
		this.image = image;
		this.description = description;
		this.amount = amount;
		this.status = status;
		this.invoiceDetails = invoiceDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_type")
	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	@Column(name = "name", length = 500)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "image", length = 120)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "amount")
	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<InvoiceDetail> getInvoiceDetails() {
		return this.invoiceDetails;
	}

	public void setInvoiceDetails(Set<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

}
