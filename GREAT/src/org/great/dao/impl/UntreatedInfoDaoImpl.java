package org.great.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.great.dao.IUntreatedInfoDao;
import org.great.entity.UntreatedInfo;
import org.great.util.DBUtil;

public class UntreatedInfoDaoImpl implements IUntreatedInfoDao{
	//查询总数据数
	@Override
	public int getTotalCount() {
		String sql = "select count(1) from untreated_information";
		return DBUtil.getTotalCount(sql);
	}

	//currentPage:当前页（页码）           pageSize:页面大小（每页显示的数据条数）
	@Override
	public List<UntreatedInfo> queryUntreatedInfosByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	//根据id查，查完返回是否存在
	@Override
	public boolean isExist(int id) {
		return queryUntreatedInfoById(id)==null?false:true;
	}
	//根据operation查，查完看是否存在
	@Override
	public boolean isExist(String operation) {
		return queryUntreatedInfoByOperation(operation)==null?false:true;
	}



	//根据id查询
	@Override
	public UntreatedInfo queryUntreatedInfoById(int id) {
		UntreatedInfo untreatedInfo = null;
		ResultSet rs = null;
		try {
			String sql = "select * from untreated_information where id=?";
			Object[] params = {id};
			
			rs = DBUtil.queryObject(sql, params);
			if (rs.next()) {
				
				String type = rs.getString("type");
				String administrator = rs.getString("administrator");
				String time = rs.getString("time");
				String operation = rs.getString("operation");
				untreatedInfo = new UntreatedInfo(id,type,administrator,time,operation);
				
			}
			return untreatedInfo;
			
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
	
	
	//根据operation查询
	@Override
	public UntreatedInfo queryUntreatedInfoByOperation(String operation) {
		UntreatedInfo untreatedInfo = null;
		ResultSet rs = null;
		try {
			String sql = "select * from untreated_information where operation=?";
			Object[] params = {operation};
			
			rs = DBUtil.queryObject(sql, params);
			if (rs.next()) {
				int id = rs.getInt("id");
				String type = rs.getString("type");
				String administrator = rs.getString("administrator");
				String time = rs.getString("time");
				untreatedInfo = new UntreatedInfo(id,type,administrator,time,operation);
			}
			return untreatedInfo;
			
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

	//查询全部信息
	@Override
	public List<UntreatedInfo> queryAllUntreatedInfos() {
		List<UntreatedInfo>untreatedInfos = new ArrayList<UntreatedInfo>();
		UntreatedInfo untreatedInfo= null;
		ResultSet rs = null;
		try {
			String sql = "select * from untreated_information order by id";
			rs = DBUtil.queryObject(sql, null);
			while (rs.next()) {
				int id = rs.getInt("id");
				String type = rs.getString("type");
				String administrator = rs.getString("administrator");
				String time = rs.getString("time");
				String operation = rs.getString("operation");
				untreatedInfo = new UntreatedInfo(id,type,administrator,time,operation);
				untreatedInfos.add(untreatedInfo);
			}
			return untreatedInfos;
			
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

	//加
	@Override
	public boolean addUntreatedInfo(UntreatedInfo untreatedInfo) {
		String sql = "insert into untreated_information values(?,?,?,?,?)";
		Object[] params= {untreatedInfo.getId(),untreatedInfo.getOperation(),untreatedInfo.getType(),untreatedInfo.getAdministrator(),untreatedInfo.getTime()};
		return DBUtil.executeADU(sql, params);
	}

	//根据id删除
	@Override
	public boolean deleteUntreatedInfo(int id) {
		String sql = "delete from untreated_information where id=?";
		Object[] params= {id};
		return DBUtil.executeADU(sql, params);
		
	}

	//根据id修改信息
	@Override
	public boolean updateUntreatedInfoById(int id, UntreatedInfo untreatedInfo) {
		return false;
	}


}
