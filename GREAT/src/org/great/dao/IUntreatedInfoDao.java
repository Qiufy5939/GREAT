package org.great.dao;

import java.util.List;

import org.great.entity.UntreatedInfo;

public interface IUntreatedInfoDao {
			//查询总数据数
			public int getTotalCount();
			
			//currentPage:当前页（页码）           pageSize:页面大小（每页显示的数据条数）
			public List<UntreatedInfo> queryUntreatedInfosByPage(int currentPage,int pageSize) ;
			
			
			//根据id查，查完返回是否存在
			public boolean isExist(int id);
			
			//根据operation查，查完返回是否存在
			public boolean isExist(String operation);
			
			//根据id查询
			public UntreatedInfo queryUntreatedInfoById(int id);
			
			//根据operation查询
			public UntreatedInfo queryUntreatedInfoByOperation(String operation);
			
			//查询全部信息
			public List<UntreatedInfo> queryAllUntreatedInfos();
			
			
			//加
			public boolean addUntreatedInfo(UntreatedInfo untreatedInfo) ;
			
			//根据id删除
			public boolean deleteUntreatedInfo(int id);
				
			//根据id修改信息
			public boolean updateUntreatedInfoById(int id,UntreatedInfo untreatedInfo);
}
