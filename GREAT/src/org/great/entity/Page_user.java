package org.great.entity;

import java.util.List;

//分页帮助类
public class Page_user {
	//当前页 currentPage
	private int currentPage;
	
	//页面大小 pageSize
	private int pageSize;
	
	//总页数 totalPage
	private int totalCount;
	
	//总数据 totalCount
	private int totalPage;
	
	//当前页的数据集合 user_informations
	private List<User_information> user_informations;

	
	public Page_user() {
		super();
	}

	public Page_user(int currentPage, int pageSize, int totalCount, int totalPage,
			List<User_information> user_informations) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.user_informations = user_informations;
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

	/*public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}*/

	public List<User_information> getUser_informations() {
		return user_informations;
	}

	public void setUser_informations(List<User_information> user_informations) {
		this.user_informations = user_informations;
	}
	
	@Override
	public String toString() {
		return "Page_user [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", user_informations=" + user_informations + "]";
	}
}
