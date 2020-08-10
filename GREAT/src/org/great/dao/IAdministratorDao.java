package org.great.dao;

import org.great.entity.Administrator;

public interface IAdministratorDao {

    //根据管理员号查询是否存在
    public boolean isExist(String ad);

    //根据管理员查询密码
    public String queryPasswordByAd(String ad);

    //根据管理员号查询管理员信息
    public Administrator queryAdministratorByAd(String ad);
}
