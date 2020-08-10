package org.great.service.impl;

import java.util.List;

import org.great.dao.ICountryDao;
import org.great.dao.impl.CountryDaoImpl;
import org.great.entity.Country;
import org.great.service.ICountryService;

//业务逻辑层：逻辑性的增删改查（增：查+增，即对dao层进行组装）
public class CountryServiceImpl implements ICountryService{
	ICountryDao countryDaoImpl = new CountryDaoImpl();
	
	//增加国家
	@Override
	public boolean addCountry(Country country) {
		//判断此国家是否不存在
		if(!countryDaoImpl.isExist(country.getEn_name())) {
			return countryDaoImpl.addCountry(country);
		}else {
			System.out.println("此国家已经存在!");
			return false;
		}
	}

	//删除国家
	@Override
	public boolean deleteCountry(String en_name) {
		//判断此国家是否存在
		if(countryDaoImpl.isExist(en_name)) {
			return countryDaoImpl.deleteCountry(en_name);
		}else {
			System.out.println("此国家不存在!");
			return false;
		}
	}

	//更新国家
	@Override
	public boolean updateCountryByEn_name(String en_name, Country country) {
		//判断此国家是否存在
		if(countryDaoImpl.isExist(en_name)) {
			return countryDaoImpl.updateCountryByEn_name(en_name, country);
		}else {
			System.out.println("此国家不存在!");
			return false;
		}
	}

	//通过英文名查询
	@Override
	public Country queryCountryByEn_name(String en_name) {
		return countryDaoImpl.queryCountryByEn_name(en_name);
	}

	//通过中文名查询
	@Override
	public Country queryCountryByCn_name(String cn_name) {
		return countryDaoImpl.queryCountryByCn_name(cn_name);
	}

	//通过首都查询
	@Override
	public Country queryCountryByCapital(String capital) {
		return countryDaoImpl.queryCountryByCapital(capital);
	}

	//返回全部国家信息
	@Override
	public List<Country> queryAllCountries() {
		return countryDaoImpl.queryAllCountries();
	}

	//返回数据总数
	@Override
	public int getTotalCount() {
		return countryDaoImpl.getTotalCount();
	}

	//返回当前某一页的国家信息
	@Override
	public List<Country> queryCountriesByPage(int currentPage, int pageSize) {
		return countryDaoImpl.queryCountriesByPage(currentPage, pageSize);
	}

	//查询满足条件的数据总数
	@Override
	public int getSearchTotalCount(String search) {
		return countryDaoImpl.getSearchTotalCount(search);
	}

	//查询满足search的当前某一页的国家信息
	@Override
	public List<Country> queryCountriesBySerachPage(String search, int currentPage, int pageSize) {
		return countryDaoImpl.queryCountrysBySerachPage(search, currentPage, pageSize);
	}

}
