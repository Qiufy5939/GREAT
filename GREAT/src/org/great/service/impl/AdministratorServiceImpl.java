package org.great.service.impl;


import org.great.dao.IAdministratorDao;
import org.great.dao.impl.AdministratorDaoImpl;
import org.great.service.IAdministratorService;

public class AdministratorServiceImpl implements IAdministratorService {

    IAdministratorDao administratorDaoImpl = new AdministratorDaoImpl();


    @Override
    public boolean queryAdByAd(String ad) {
        return administratorDaoImpl.isExist(ad);
    }

    @Override
    public String queryPwdByAd(String ad) {
        return administratorDaoImpl.queryPasswordByAd(ad);
    }
}
