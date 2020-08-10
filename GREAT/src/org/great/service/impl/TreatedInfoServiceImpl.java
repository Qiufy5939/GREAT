package org.great.service.impl;

import java.util.List;

import org.great.dao.ITreatedInfoDao;
import org.great.dao.impl.TreatedInfoDaoImpl;
import org.great.entity.TreatedInfo;
import org.great.service.ITreatedInfoService;

public class TreatedInfoServiceImpl implements ITreatedInfoService{

	ITreatedInfoDao treatedInfoDaoImpl = new TreatedInfoDaoImpl();
	
	//增
	@Override
	public boolean addTreatedInfo(TreatedInfo treatedInfo) {
		//判断此信息是否不存在
		if(!treatedInfoDaoImpl.isExist(treatedInfo.getId())) {
					return treatedInfoDaoImpl.addTreatedInfo(treatedInfo);
				}else {
					System.out.println("此信息被申请过!");
					return false;
				}
	}

	//删
	@Override
	public boolean deleteTreatedInfo(int id) {
		//判断此信息是否存在
		if(treatedInfoDaoImpl.isExist(id)) {
			return treatedInfoDaoImpl.deleteTreatedInfo(id);
		}else {
			System.out.println("此请求信息已经不存在!");
			return false;
		}
	}

	//改
	@Override
	public boolean updateTreatedInfoById(int id, TreatedInfo treatedInfo) {
		//判断此信息是否存在
				if(treatedInfoDaoImpl.isExist(id)) {
					return treatedInfoDaoImpl.updateTreatedInfoById(id, treatedInfo);
				}else {
					System.out.println("此请求信息已经不存在!");
					return false;
				}
	}

	//查
	//根据id查询已处理信息
	@Override
	public TreatedInfo queryTreatedInfoById(int id) {
		return treatedInfoDaoImpl.queryTreatedInfoById(id);
	}

	//查询全部已处理信息
	@Override
	public List<TreatedInfo> queryAllTreatedInfos() {
		return treatedInfoDaoImpl.queryAllTreatedInfos();
	}

	//查询数据总数
	@Override
	public int getTotalCount() {
		return treatedInfoDaoImpl.getTotalCount();
	}

	//查询当前某一页的(已处理信息)
	@Override
	public List<TreatedInfo> queryTreatedInfosByPage(int currentPage, int pageSize) {
		return treatedInfoDaoImpl.queryTreatedInfosByPage(currentPage, pageSize);
	}

}
