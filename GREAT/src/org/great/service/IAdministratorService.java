package org.great.service;

public interface IAdministratorService {
    //查
    //1.根据管理员查是否存在
    public boolean queryAdByAd(String ad);

    //2.根据管理员查密码
    public String queryPwdByAd(String ad);
}
