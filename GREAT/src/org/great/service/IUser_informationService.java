package org.great.service;

import java.util.List;

import org.great.entity.User_information;

public interface IUser_informationService {
	
	//增
	public boolean addUser_information(User_information user_information);
	
	//删
	public boolean deleteUser_information(String user);
	
	//改
	public boolean updateUser_informationByUser(String user,User_information user_information);
	
	
	//查
	//根据user查询
	public User_information queryUser_informationByUser(String user);
	
	//根据phone查询
	public User_information queryUser_informationByPhone(String phone);
	
	
	//查询全部用户
	public List<User_information> queryAllUser_informations();
	
	//查询数据总数
	public int getTotalCount();
	
	//查询当前某一页的用户信息
	public List<User_information> queryUser_informationsByPage(int currentPage,int pageSize);
	
	
	//查询满足条件的数据总数
	public int getSearchTotalCount(String search);
	
	//查询满足search的当前某一页的用户信息
	public List<User_information> queryUser_informationsBySerachPage(String search,int currentPage,int pageSize);
}
