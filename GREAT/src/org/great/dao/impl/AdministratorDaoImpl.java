package org.great.dao.impl;

import org.great.dao.IAdministratorDao;
import org.great.entity.Administrator;
import org.great.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministratorDaoImpl implements IAdministratorDao {
    @Override
    public boolean isExist(String ad) {
        return queryAdministratorByAd(ad)==null?false:true;
    }

    @Override
    public String queryPasswordByAd(String ad) {
    	if(isExist(ad)) {
	        Administrator administrator = queryAdministratorByAd(ad);
	        return administrator.getPassword();
    	}
        return null;
    }

    @Override
    public Administrator queryAdministratorByAd(String ad) {
        Administrator administrator = null;
        ResultSet rs = null;
        try {
            String sql = "select * from administrator where ad_name=?";
            Object[] params = {ad};

            rs = DBUtil.queryObject(sql, params);
            if (rs.next()) {
                String ad_id = rs.getString("ad_name");
                String ad_password = rs.getString("password");
                administrator = new Administrator(ad_id,ad_password);
            }
            return administrator;

        }catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }finally {
            try {
                if(rs!=null) rs.close();
            }catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            DBUtil.closeAll(DBUtil.rs, DBUtil.pst, DBUtil.connection);
        }
    }

}
