package com.cmf.sale.model.api;

import java.util.List;

import com.google.gson.annotations.Expose;

public class CMFResponse<T> {
	@Expose
	protected String requestId;
	@Expose
	protected String requestAction;
	@Expose
	protected boolean error = false;
	@Expose
	protected String toastMessage = "";
	@Expose
	protected List<ErrorField> errorFields;
	@Expose
	protected int totalRecord;
	@Expose
	protected T object;
	

	public CMFResponse() {
		super();
	}

	public CMFResponse(String requestId, String requestAction, boolean error, String toastMessage,
			List<ErrorField> errorFields, T object, int totalRecord) {
		super();
		this.requestId = requestId;
		this.requestAction = requestAction;
		this.error = error;
		this.toastMessage = toastMessage;
		this.errorFields = errorFields;
		this.object = object;
		this.totalRecord = totalRecord;
	}

	public String getRequestId() {
		return requestId;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestAction() {
		return requestAction;
	}

	public void setRequestAction(String requestAction) {
		this.requestAction = requestAction;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getToastMessage() {
		return toastMessage;
	}

	public void setToastMessage(String toastMessage) {
		this.toastMessage = toastMessage;
	}

	public List<ErrorField> getErrorFields() {
		return errorFields;
	}

	public void setErrorFields(List<ErrorField> errorFields) {
		this.errorFields = errorFields;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

}
