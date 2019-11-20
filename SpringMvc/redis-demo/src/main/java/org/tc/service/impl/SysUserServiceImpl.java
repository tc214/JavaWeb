package org.tc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tc.bean.UserInfo;
import org.tc.cache.RedisUtils;
import org.tc.service.SysUserService;


@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private RedisUtils redisUtils;



    @Override
    public UserInfo findUserByName(String userName) {
        if (userName != null && !userName.isEmpty()) {
            UserInfo userInfo = redisUtils.get(userName, UserInfo.class);
            if (userInfo == null) {
                userInfo = new UserInfo();
                userInfo.setUserName("test");
                redisUtils.set(userName, userInfo);
            }
            return userInfo;
        }
        return null;
    }

    @Override
    public String getValueByKey(String key) {
        if (key == null || key.isEmpty()) {
            return key;
        }
        String value = redisUtils.get(key);
        if (value == null) {
            value = "test redis";
            redisUtils.set(key, value, 60);
        }
        return value;
    }


}
