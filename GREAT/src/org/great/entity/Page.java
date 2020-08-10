package org.great.entity;

import java.util.List;

//分页帮助类
public class Page {
	//当前页 currentPage
	private int currentPage;
	
	//页面大小 pageSize
	private int pageSize;
	
	//总页数 totalPage
	private int totalCount;
	
	//总数据 totalCount
	private int totalPage;
	
	//当前页的数据集合 countries
	private List<Country> countries;
	
	
	public Page() {
		
	};

	public Page(int currentPage, int pageSize, int totalCount, int totalPage, List<Country> countries) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.countries = countries;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		
		//根据 总条数 和 页面数 得出总页数
		this.totalPage = this.totalCount % this.pageSize==0 ? this.totalCount/this.pageSize : this.totalCount/this.pageSize+1;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

/*	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}*/

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	
}
