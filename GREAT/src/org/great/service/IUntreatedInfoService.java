package org.great.service;

import java.util.List;

import org.great.entity.UntreatedInfo;


public interface IUntreatedInfoService {
		//增
		public boolean addUntreatedInfo(UntreatedInfo untreatedInfo);
		
		//删
		public boolean deleteUntreatedInfo(int id);
		
		//改
		public boolean updateUntreatedInfoById(int id,UntreatedInfo untreatedInfo);
		
		
		//查
		//根据id查询未处理信息
		public UntreatedInfo queryUntreatedInfoById(int id);
		
		//根据operation查询未处理信息
		public UntreatedInfo queryUntreatedInfoByOperation(String operation);
		
		//查询全部未处理信息
		public List<UntreatedInfo> queryAllUntreatedInfos();
		
		//查询数据总数
		public int getTotalCount();
		//查询当前某一页的(未处理信息)
		public List<UntreatedInfo> queryUntreatedInfosByPage(int currentPage,int pageSize);
}
