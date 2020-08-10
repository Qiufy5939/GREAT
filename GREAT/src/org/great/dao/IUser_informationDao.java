package org.great.dao;

import java.util.List;

import org.great.entity.User_information;


public interface IUser_informationDao {
	//查询总数据数
	public int getTotalCount();
	
	//currentPage:当前页（页码）           pageSize:页面大小（每页显示的数据条数）
	public List<User_information> queryUser_informationsByPage(int currentPage,int pageSize) ;
	
	
	//根据user查，查完返回是否存在
	public boolean isExist(String user);
	
	//根据user查询
	public User_information queryUser_informationByUser(String user);
	
	//根据phone查询
	public User_information queryUser_informationByPhone(String phone);
	
	
	//查询全部用户
	public List<User_information> queryAllUser_informations();
	
	
	//根据信息加用户
	public boolean addUser_information(User_information user_information) ;
	
	//根据user删除用户
	public boolean deleteUser_information(String user);
	
	//根据user修改信息，把这个用户做修改
	public boolean updateUser_informationByUser(String user,User_information user_information);
	
	//查询满足条件的数据总数
	public int getSearchTotalCount(String search);
		
	//查询满足search的当前某一页的用户信息
	public List<User_information> queryUser_informationsBySerachPage(String search,int currentPage,int pageSize);
}
