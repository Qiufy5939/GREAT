package org.great.dao;

import java.util.List;

import org.great.entity.TreatedInfo;



public interface ITreatedInfoDao {
	//查询总数据数
	public int getTotalCount();
	
	//currentPage:当前页（页码）           pageSize:页面大小（每页显示的数据条数）
	public List<TreatedInfo> queryTreatedInfosByPage(int currentPage,int pageSize) ;
	
	
	//根据id查，查完返回是否存在
	public boolean isExist(int id);
	
	//根据id查询
	public TreatedInfo queryTreatedInfoById(int id);
	
	
	//查询全部信息
	public List<TreatedInfo> queryAllTreatedInfos();
	
	
	//加
	public boolean addTreatedInfo(TreatedInfo treatedInfo) ;
	
	//根据id删除
	public boolean deleteTreatedInfo(int id);
		
	//根据id修改信息
	public boolean updateTreatedInfoById(int id,TreatedInfo treatedInfo);
}
