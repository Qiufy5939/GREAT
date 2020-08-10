package org.great.service;

import java.util.List;

import org.great.entity.Country;
import org.great.entity.User_information;


public interface ICountryService {
	
	//增
	public boolean addCountry(Country country);
	
	//删
	public boolean deleteCountry(String en_name);
	
	//改
	public boolean updateCountryByEn_name(String en_name,Country country);
	
	
	//查
	//根据英文名查询国家
	public Country queryCountryByEn_name(String en_name);
	//根据中文名查询国家
	public Country queryCountryByCn_name(String cn_name);
	//根据首都查询国家
	public Country queryCountryByCapital(String capital);
	
	//查询全部国家
	public List<Country> queryAllCountries();
	
	//查询数据总数
	public int getTotalCount();
	//查询当前某一页的国家信息
	public List<Country> queryCountriesByPage(int currentPage,int pageSize);
	
	//查询满足条件的数据总数
	public int getSearchTotalCount(String search);
	
	//查询满足search的当前某一页的国家信息
	public List<Country> queryCountriesBySerachPage(String search,int currentPage,int pageSize);
}
