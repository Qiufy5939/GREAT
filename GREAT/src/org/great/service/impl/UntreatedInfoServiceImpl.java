package org.great.service.impl;

import java.util.List;

import org.great.dao.IUntreatedInfoDao;
import org.great.dao.impl.UntreatedInfoDaoImpl;
import org.great.entity.UntreatedInfo;
import org.great.service.IUntreatedInfoService;

public class UntreatedInfoServiceImpl implements IUntreatedInfoService{
	IUntreatedInfoDao untreatedInfoDaoImpl = new UntreatedInfoDaoImpl(); 
	
	//增
	@Override
	public boolean addUntreatedInfo(UntreatedInfo untreatedInfo) {
		//判断此信息是否不存在
		if(!untreatedInfoDaoImpl.isExist(untreatedInfo.getId())) {
					return untreatedInfoDaoImpl.addUntreatedInfo(untreatedInfo);
				}else {
					System.out.println("此信息被申请过!");
					return false;
				}
	}

	//删
	@Override
	public boolean deleteUntreatedInfo(int id) {
		//判断此信息是否存在
		if(untreatedInfoDaoImpl.isExist(id)) {
			return untreatedInfoDaoImpl.deleteUntreatedInfo(id);
		}else {
			System.out.println("此请求信息已经不存在!");
			return false;
		}
		
	}

	//改
	@Override
	public boolean updateUntreatedInfoById(int id, UntreatedInfo untreatedInfo) {
		//判断此信息是否存在
		if(untreatedInfoDaoImpl.isExist(id)) {
			return untreatedInfoDaoImpl.updateUntreatedInfoById(id, untreatedInfo);
		}else {
			System.out.println("此请求信息已经不存在!");
			return false;
		}
	}

	//根据id查询
	@Override
	public UntreatedInfo queryUntreatedInfoById(int id) {
		return untreatedInfoDaoImpl.queryUntreatedInfoById(id);
	}

	//根据operation查询
	@Override
	public UntreatedInfo queryUntreatedInfoByOperation(String operation) {
		return untreatedInfoDaoImpl.queryUntreatedInfoByOperation(operation);
	}	
	
	
	//查询全部
	@Override
	public List<UntreatedInfo> queryAllUntreatedInfos() {
		return untreatedInfoDaoImpl.queryAllUntreatedInfos();
	}

	//查询数据总数
	@Override
	public int getTotalCount() {
		return untreatedInfoDaoImpl.getTotalCount();
	}

	//查询当前页的数据
	@Override
	public List<UntreatedInfo> queryUntreatedInfosByPage(int currentPage, int pageSize) {
		return untreatedInfoDaoImpl.queryUntreatedInfosByPage(currentPage, pageSize);
	}





	

}
