package com.cmf.sale.model.views;

import com.google.gson.annotations.Expose;

public class ErrorField {
	@Expose
	private String code;
	@Expose
	private String field;
	@Expose
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
