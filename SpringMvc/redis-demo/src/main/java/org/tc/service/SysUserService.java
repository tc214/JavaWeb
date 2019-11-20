package org.tc.service;


import org.tc.bean.UserInfo;

public interface SysUserService {

    public UserInfo findUserByName(String userName);

    public String getValueByKey(String key);



}
