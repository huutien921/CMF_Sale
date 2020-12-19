package com.cmf.sale.model.api;

public class CMFPageRequest {

	protected Integer pageNumber;
	protected Integer limit;
	protected String sFieldSort;
	protected String sSort;
	protected String search;

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getsFieldSort() {
		return sFieldSort;
	}

	public void setsFieldSort(String sFieldSort) {
		this.sFieldSort = sFieldSort;
	}

	public String getsSort() {
		return sSort;
	}

	public void setsSort(String sSort) {
		this.sSort = sSort;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
