package org.great.dao;

import java.util.List;

import org.great.entity.Country;


public interface ICountryDao {
		//查询总数据数
		public int getTotalCount();
		
		//currentPage:当前页（页码）           pageSize:页面大小（每页显示的数据条数）
		public List<Country> queryCountriesByPage(int currentPage,int pageSize) ;
		
		
		//根据英文名查国家，查完返回是否存在
		public boolean isExist(String en_name);
		
		//根据英文名查询
		public Country queryCountryByEn_name(String en_name);
		
		//根据中文名查询
		public Country queryCountryByCn_name(String cn_name);
		
		//根据首都查询
		public Country queryCountryByCapital(String capital);
		
		//查询全部国家
		public List<Country> queryAllCountries();
		
		
		//根据信息加国家
		public boolean addCountry(Country country) ;
		
		//根据英文名删除国家
		public boolean deleteCountry(String en_name);
			
		//根据英文名修改国家信息，把这个国家修改成country
		public boolean updateCountryByEn_name(String en_name,Country country);
		
		//查询满足条件的数据总数
		public int getSearchTotalCount(String search);
			
		//查询满足search的当前某一页的国家信息
		public List<Country> queryCountrysBySerachPage(String search,int currentPage,int pageSize);
}
