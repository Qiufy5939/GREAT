package org.great.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.great.dao.ICountryDao;
import org.great.entity.Country;
import org.great.util.DBUtil;




//数据访问层：原子性的增删查改
public class CountryDaoImpl implements ICountryDao{

	//获取数据总量
	@Override
	public int getTotalCount() {
		String sql = "select count(1) from country";
		return DBUtil.getTotalCount(sql);
	}

	//获取某一页的国家信息集合
	@Override
	public List<Country> queryCountriesByPage(int currentPage, int pageSize) {
		List<Country>countries = new ArrayList<Country>();
		Country country = null;
		ResultSet rs = null;
		try {
			String sql = "select * from country limit ?,?";
			Object[] params = {(currentPage-1)*pageSize,pageSize};	//注意减1，因为是从0索引开始
			rs = DBUtil.queryObject(sql, params);
			while (rs.next()) {
				String en_name = rs.getString("en_name");
				String cn_name = rs.getString("cn_name");
				String capital = rs.getString("capital");
				String flag = rs.getString("flag");
				String introduction = rs.getString("introduction");
				country = new Country(en_name,cn_name,capital,flag,introduction);
				countries.add(country);
			}
			return countries;
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {
				try {
					if(rs!=null) rs.close();
					}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				    }catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				    }
				DBUtil.closeAll(DBUtil.rs, DBUtil.pst, DBUtil.connection);
			     }
	
	}

	//根据英文名查询国家，返回是否存在
	@Override
	public boolean isExist(String en_name) {
		return queryCountryByEn_name(en_name)==null?false:true;
	}

	//根据英文名查询国家
	@Override
	public Country queryCountryByEn_name(String en_name) {
		Country country = null;
		ResultSet rs = null;
		try {
			String sql = "select * from country where en_name=?";
			Object[] params = {en_name};
			
			rs = DBUtil.queryObject(sql, params);
			if (rs.next()) {
				String cn_name = rs.getString("cn_name");
				String capital = rs.getString("capital");
				String flag = rs.getString("flag");
				String introduction = rs.getString("introduction");
				country = new Country(en_name,cn_name,capital,flag,introduction);
			}
			return country;
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {
				try {
					if(rs!=null) rs.close();
					}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				    }catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				    }
				DBUtil.closeAll(DBUtil.rs, DBUtil.pst, DBUtil.connection);
			     }
	}

	//根据中文名查询国家
	@Override
	public Country queryCountryByCn_name(String cn_name) {
		Country country = null;
		ResultSet rs = null;
		try {
			String sql = "select * from country where cn_name=?";
			Object[] params = {cn_name};
			
			rs = DBUtil.queryObject(sql, params);
			if (rs.next()) {
				String sn_name = rs.getString("sn_name");
				String capital = rs.getString("capital");
				String flag = rs.getString("flag");
				String introduction = rs.getString("introduction");
				country = new Country(sn_name,cn_name,capital,flag,introduction);
			}
			return country;
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {
				try {
					if(rs!=null) rs.close();
					}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				    }catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				    }
				DBUtil.closeAll(DBUtil.rs, DBUtil.pst, DBUtil.connection);
			     }
	}

	//根据首都名查询国家
	@Override
	public Country queryCountryByCapital(String capital) {
		Country country = null;
		ResultSet rs = null;
		try {
			String sql = "select * from country where capital=?";
			Object[] params = {capital};
			
			rs = DBUtil.queryObject(sql, params);
			if (rs.next()) {
				String en_name = rs.getString("en_name");
				String cn_name = rs.getString("cn_name");
				String flag = rs.getString("flag");
				String introduction = rs.getString("introduction");
				country = new Country(en_name,cn_name,capital,flag,introduction);
			}
			return country;
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {
				try {
					if(rs!=null) rs.close();
					}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				    }catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				    }
				DBUtil.closeAll(DBUtil.rs, DBUtil.pst, DBUtil.connection);
			     }
	}

	//查询所有国家信息
	@Override
	public List<Country> queryAllCountries() {
		List<Country>countries = new ArrayList<Country>();
		Country country = null;
		ResultSet rs = null;
		try {
			String sql = "select * from country";
			rs = DBUtil.queryObject(sql, null);
			while (rs.next()) {
				String en_name = rs.getString("en_name");
				String cn_name = rs.getString("cn_name");
				String capital = rs.getString("capital");
				String flag = rs.getString("flag");
				String introduction = rs.getString("introduction");
				country = new Country(en_name,cn_name,capital,flag,introduction);
				countries.add(country);
			}
			return countries;
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {
				try {
					if(rs!=null) rs.close();
					}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				    }catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				    }
				DBUtil.closeAll(DBUtil.rs, DBUtil.pst, DBUtil.connection);
			     }
	}

	//添加国家
	@Override
	public boolean addCountry(Country country) {
		String sql = "insert into country values(?,?,?,?,?)";
		Object[] params= {country.getEn_name(),country.getCn_name(),country.getCapital(),country.getFlag(),country.getIntroduction()};
		return DBUtil.executeADU(sql, params);
	}

	//通过英文名删除国家
	@Override
	public boolean deleteCountry(String en_name) {
		String sql = "delete from country where en_name=?";
		Object[] params= {en_name};
		return DBUtil.executeADU(sql, params);
	}

	//通过英文名更新国家
	@Override
	public boolean updateCountryByEn_name(String en_name, Country country) {
		String sql = "update country set cn_name=?,capital=?,flag=?,introduction=? where en_name=?";
		Object[] params	= {country.getCn_name(),country.getCapital(),country.getFlag(),country.getIntroduction(),en_name};
		return DBUtil.executeADU(sql, params);	
	}

	//查询满足条件的数据总数
	@Override
	public int getSearchTotalCount(String search) {
		String sql = "select count(1) from country where en_name like concat('%',?,'%')  or cn_name like concat('%',?,'%') or capital like concat('%',?,'%')";
		Object[] params = {search,search,search};
		return DBUtil.getSearchTotalCount(sql,params);
	}

	//查询满足search的当前某一页的国家信息
	@Override
	public List<Country> queryCountrysBySerachPage(String search, int currentPage, int pageSize) {
		List<Country>countries = new ArrayList<Country>();
		Country country = null;
		ResultSet rs = null;
		try {
			String sql = "select * from country where en_name like concat('%',?,'%')  or cn_name like concat('%',?,'%') or capital like concat('%',?,'%') limit ?,?";
			Object[] params = {search,search,search,(currentPage-1)*pageSize,pageSize};	//注意减1，因为是从0索引开始
			rs = DBUtil.queryObject(sql, params);
			while (rs.next()) {
				String en_name = rs.getString("en_name");
				String cn_name = rs.getString("cn_name");
				String capital = rs.getString("capital");
				String flag = rs.getString("flag");
				String introduction = rs.getString("introduction");
				country = new Country(en_name,cn_name,capital,flag,introduction);
				countries.add(country);
			}
			return countries;
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {
				try {
					if(rs!=null) rs.close();
					}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				    }catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				    }
				DBUtil.closeAll(DBUtil.rs, DBUtil.pst, DBUtil.connection);
			     }
	}
}
