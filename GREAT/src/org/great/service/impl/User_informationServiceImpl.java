package org.great.service.impl;

import java.util.List;

import org.great.dao.IUser_informationDao;
import org.great.dao.impl.User_informationDaoImpl;
import org.great.entity.User_information;
import org.great.service.IUser_informationService;

//业务逻辑层：逻辑性的增删改查（增：查+增，即对dao层进行组装）
public class User_informationServiceImpl implements IUser_informationService{
	
	IUser_informationDao user_informationDaoImpl = new User_informationDaoImpl();
	
	//增加用户
	@Override
	public boolean addUser_information(User_information user_information) {
		//判断此用户是否不存在
		if(!user_informationDaoImpl.isExist(user_information.getUser())) {
			return user_informationDaoImpl.addUser_information(user_information);
		}else {
			System.out.println("此用户已经存在!");
			return false;
		}
	}
	
	//删除用户
	@Override
	public boolean deleteUser_information(String user) {
		//判断此用户是否存在
		if(user_informationDaoImpl.isExist(user)) {
			return user_informationDaoImpl.deleteUser_information(user);
		}else {
			System.out.println("此用户不存在!");
			return false;
		}		
	}

	//更新用户
	@Override
	public boolean updateUser_informationByUser(String user, User_information user_information) {
		//判断此用户是否存在
		if(user_informationDaoImpl.isExist(user)) {
			return user_informationDaoImpl.updateUser_informationByUser(user, user_information);
		}else {
			System.out.println("此用户不存在!");
			return false;
		}
	}

	//查
	//根据user查询	
	@Override
	public User_information queryUser_informationByUser(String user) {
		return user_informationDaoImpl.queryUser_informationByUser(user);
	}

	//根据phone查询	
	@Override
	public User_information queryUser_informationByPhone(String phone) {
		return user_informationDaoImpl.queryUser_informationByPhone(phone);
	}

	
	//查询全部用户
	@Override
	public List<User_information> queryAllUser_informations() {
		return user_informationDaoImpl.queryAllUser_informations();
	}
	
	
	//查询数据总数
	@Override
	public int getTotalCount() {
		return user_informationDaoImpl.getTotalCount();
	}

	
	//查询当前某一页的用户信息
	@Override
	public List<User_information> queryUser_informationsByPage(int currentPage, int pageSize) {
		return user_informationDaoImpl.queryUser_informationsByPage(currentPage, pageSize);
	}

	//查询满足条件的数据总数
	@Override
	public int getSearchTotalCount(String search) {
		return user_informationDaoImpl.getSearchTotalCount(search);
	}

	//查询满足search的当前某一页的用户信息
	@Override
	public List<User_information> queryUser_informationsBySerachPage(String search,int currentPage, int pageSize) {
		return user_informationDaoImpl.queryUser_informationsBySerachPage(search, currentPage, pageSize);
	}
	

}
