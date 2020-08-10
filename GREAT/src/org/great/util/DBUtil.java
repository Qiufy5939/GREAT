package org.great.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


//通用的数据操作方法	//不针对某一类
public class DBUtil {
	private static final String URL = "jdbc:mysql://39.96.56.179:3306/great?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "@C401MiMa";//101.200.190.34++127.0.0.1
		
	public static Connection connection = null;
	public static PreparedStatement pst = null;	
	public static ResultSet rs = null;
	
	//通用的获取记录总数
	public static int getTotalCount(String sql) {
		int count = -1;
		try {
			rs = queryObject(sql, null);
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(rs, pst, connection);
		}
		return count;
	}
	
	
	//通用的增删改
	public static boolean executeADU(String sql,Object[] params) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			///////////替换部分，其余一样
			pst = connection.prepareStatement(sql);
			if(params!=null) {
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i+1, params[i]);
				}
			}
			//////////////////////////
			
			int count = pst.executeUpdate();
			if (count>0) 
				return true;
			return false;
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally {
				closeAll(null, pst, connection);
	}
}
	
	//通用的查询:返回值是一个ResultSet
	public static ResultSet queryObject(String sql,Object[] params) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

			////////替换部分/////////
			pst = connection.prepareStatement(sql);
			if (params!=null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i+1, params[i]);
				}				
			}
			////////////////////
			rs = pst.executeQuery();
			return rs;
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeAll(ResultSet rs,Statement st,Connection connection) {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if (connection!=null) connection.close();
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		    }
	}
	
	//查询满足条件的数据总数
		public static int getSearchTotalCount(String sql , Object[] params) {
			int count = -1;
			try {
				rs = queryObject(sql, params);
				if (rs.next()) {
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				closeAll(rs, pst, connection);
			}
			return count;
		}
}
