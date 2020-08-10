package org.great.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.great.dao.ITreatedInfoDao;
import org.great.entity.TreatedInfo;
import org.great.util.DBUtil;

public class TreatedInfoDaoImpl implements ITreatedInfoDao{

	//查询总数据数
	@Override
	public int getTotalCount() {
		String sql = "select count(1) from treated_information";
		return DBUtil.getTotalCount(sql);
	}

	//currentPage:当前页（页码）           pageSize:页面大小（每页显示的数据条数）
	@Override
	public List<TreatedInfo> queryTreatedInfosByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	//根据id查，查完返回是否存在
	@Override
	public boolean isExist(int id) {
		return queryTreatedInfoById(id)==null?false:true;
	}

	//根据id查询
	@Override
	public TreatedInfo queryTreatedInfoById(int id) {
		TreatedInfo treatedInfo = null;
		ResultSet rs = null;
		try {
			String sql = "select * from treated_information where id=?";
			Object[] params = {id};
			
			rs = DBUtil.queryObject(sql, params);
			if (rs.next()) {
				String type = rs.getString("type");
				String content = rs.getString("content");
				String applicant = rs.getString("applicant");
				String application_date = rs.getString("application_date");
				String checker = rs.getString("checker");
				String check_date = rs.getString("check_date");
				String result = rs.getString("result");
				treatedInfo = new TreatedInfo(id,type,content,applicant,application_date,checker,check_date,result);
				
			}
			return treatedInfo;
			
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
	public List<TreatedInfo> queryAllTreatedInfos() {
		List<TreatedInfo>treatedInfos = new ArrayList<TreatedInfo>();
		TreatedInfo treatedInfo= null;
		ResultSet rs = null;
		try {
			String sql = "select * from treated_information order by check_date desc";
			rs = DBUtil.queryObject(sql, null);
			while (rs.next()) {
				int id = rs.getInt("id");
				String type = rs.getString("type");
				String content = rs.getString("content");
				String applicant = rs.getString("applicant");
				String application_date = rs.getString("application_date");
				String checker = rs.getString("checker");
				String check_date = rs.getString("check_date");
				String result = rs.getString("result");
				treatedInfo = new TreatedInfo(id,type,content,applicant,application_date,checker,check_date,result);
				treatedInfos.add(treatedInfo);
			}
			return treatedInfos;
			
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
	public boolean addTreatedInfo(TreatedInfo treatedInfo) {
		String sql = "insert into treated_information values(?,?,?,?,?,?,?,?)";
		Object[] params= {treatedInfo.getId(),treatedInfo.getContent(),treatedInfo.getType(),
				treatedInfo.getApplicant(),treatedInfo.getApplication_date(),treatedInfo.getChecker(),
				treatedInfo.getCheck_date(),treatedInfo.getResult()};
		return DBUtil.executeADU(sql, params);
	}

	//根据id删除
	@Override
	public boolean deleteTreatedInfo(int id) {
		String sql = "delete from treated_information where id=?";
		Object[] params= {id};
		return DBUtil.executeADU(sql, params);
	}

	//根据id修改信息
	@Override
	public boolean updateTreatedInfoById(int id, TreatedInfo treatedInfo) {
		return false;
	}
	
}
