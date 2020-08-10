package org.great.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.great.dao.IUser_informationDao;
import org.great.entity.User_information;
import org.great.util.DBUtil;


//数据访问层，原子性的增删查改
public class User_informationDaoImpl implements IUser_informationDao{
	//查询总数据数
	@Override
	public int getTotalCount() {
		String sql = "select count(1) from user_information";
		return DBUtil.getTotalCount(sql);
	}

	
	//获取某一页的用户信息集合
	//currentPage:当前页（页码）           pageSize:页面大小（每页显示的数据条数）
	@Override
	public List<User_information> queryUser_informationsByPage(int currentPage, int pageSize) {
		List<User_information>user_informations = new ArrayList<User_information>();
		User_information user_information = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user_information limit ?,?";
			Object[] params = {(currentPage-1)*pageSize,pageSize};	//注意减1，因为是从0索引开始
			rs = DBUtil.queryObject(sql, params);
			while (rs.next()) {
				String user = rs.getString("user");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String registration_time = rs.getString("registration_time");
				String login_time = rs.getString("login_time");
				String status = rs.getString("status");
				user_information = new User_information(user,password,phone,registration_time,login_time,status);
				user_informations.add(user_information);
			}
			return user_informations;
			
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

	//根据user查，查完返回是否存在
	@Override
	public boolean isExist(String user) {
		return queryUser_informationByUser(user)==null?false:true;
	}

	//根据user查询
	@Override
	public User_information queryUser_informationByUser(String user) {
		User_information user_information = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user_information where user=?";
			Object[] params = {user};
			
			rs = DBUtil.queryObject(sql, params);
			if (rs.next()) {
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String registration_time = rs.getString("registration_time");
				String login_time = rs.getString("login_time");
				String status = rs.getString("status");
				user_information = new User_information(user,password,phone,registration_time,login_time,status);
			}
			return user_information;
			
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


	//根据phone查询
	@Override
	public User_information queryUser_informationByPhone(String phone) {
		User_information user_information = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user_information where phone=?";
			Object[] params = {phone};
			
			rs = DBUtil.queryObject(sql, params);
			if (rs.next()) {
				String user = rs.getString("user");
				String password = rs.getString("password");
				String registration_time = rs.getString("registration_time");
				String login_time = rs.getString("login_time");
				String status = rs.getString("status");
				user_information = new User_information(user,password,phone,registration_time,login_time,status);
			}
			return user_information;
			
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

	//查询全部用户
	@Override
	public List<User_information> queryAllUser_informations() {
		List<User_information>user_informations = new ArrayList<User_information>();
		User_information user_information = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user_information";
			rs = DBUtil.queryObject(sql, null);
			while (rs.next()) {
				String user = rs.getString("user");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String registration_time = rs.getString("registration_time");
				String login_time = rs.getString("login_time");
				String status = rs.getString("status");
				user_information = new User_information(user,password,phone,registration_time,login_time,status);
				user_informations.add(user_information);
			}
			return user_informations;
			
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

	//根据信息加用户
	@Override
	public boolean addUser_information(User_information user_information) {
		String sql = "insert into user_information values(?,?,?,?,?,?)";
		Object[] params= {user_information.getUser(),user_information.getPassword(),user_information.getPhone(),user_information.getRegistration_time(),user_information.getLogin_time(),user_information.getStatus()};
		return DBUtil.executeADU(sql, params);
	}

	//根据user删除用户
	@Override
	public boolean deleteUser_information(String user) {
		String sql = "delete from user_information where user=?";
		Object[] params= {user};
		return DBUtil.executeADU(sql, params);
	}

	//根据user修改信息，修改这个用户信息
	@Override
	public boolean updateUser_informationByUser(String user, User_information user_information) {
		String sql = "update user_information set password=?,phone=?,registration_time=?,login_time=?,status=? where user=?";
		Object[] params	= {user_information.getPassword(),user_information.getPhone(),user_information.getRegistration_time(),user_information.getLogin_time(),user_information.getStatus(),user};
		return DBUtil.executeADU(sql, params);	
	}


	//查询满足search条件的数据总数
	@Override
	public int getSearchTotalCount(String search) {
		
		if ("lock".equals(search)||"unlock".equals(search)) {
			String sql = "select count(1) from user_information where status=?";
			Object[] params = {search};
			return DBUtil.getSearchTotalCount(sql,params);
		
		}else {
			String sql = "select count(1) from user_information where user like concat('%',?,'%')  or phone like concat('%',?,'%')";
			Object[] params = {search,search};
			return DBUtil.getSearchTotalCount(sql,params);
		}
	}


	//查询满足search的当前某一页的用户信息
	@Override
	public List<User_information> queryUser_informationsBySerachPage(String search, int currentPage, int pageSize) {
		
		String sql = null;
		Object[] params = null;
		
		if ("lock".equals(search)||"unlock".equals(search)) {
			sql = "select * from user_information where status=? limit ?,?";
			Object[] temp = {search,(currentPage-1)*pageSize,pageSize};//注意减1，因为是从0索引开始
			params = temp;
		
		}else {
			sql = "select * from user_information where user like concat('%',?,'%')  or phone like concat('%',?,'%') limit ?,?";
			Object[] temp = {search,search,(currentPage-1)*pageSize,pageSize};//注意减1，因为是从0索引开始
			params = temp;
		}
		
		List<User_information>user_informations = new ArrayList<User_information>();
		User_information user_information = null;
		ResultSet rs = null;
		try {
			rs = DBUtil.queryObject(sql, params);
			while (rs.next()) {
				String user = rs.getString("user");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String registration_time = rs.getString("registration_time");
				String login_time = rs.getString("login_time");
				String status = rs.getString("status");
				user_information = new User_information(user,password,phone,registration_time,login_time,status);
				user_informations.add(user_information);
			}
			return user_informations;
			
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
