package org.great.service;

import java.util.List;

import org.great.entity.TreatedInfo;


public interface ITreatedInfoService {
			//增
			public boolean addTreatedInfo(TreatedInfo treatedInfo);
			
			//删
			public boolean deleteTreatedInfo(int id);
			
			//改
			public boolean updateTreatedInfoById(int id,TreatedInfo treatedInfo);
			
			
			//查
			//根据id查询已处理信息
			public TreatedInfo queryTreatedInfoById(int id);
			
			
			//查询全部已处理信息
			public List<TreatedInfo> queryAllTreatedInfos();
			
			//查询数据总数
			public int getTotalCount();
			//查询当前某一页的(未处理信息)
			public List<TreatedInfo> queryTreatedInfosByPage(int currentPage,int pageSize);
}
