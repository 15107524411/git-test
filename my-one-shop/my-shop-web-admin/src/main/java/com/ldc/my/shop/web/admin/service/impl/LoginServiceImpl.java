package com.ldc.my.shop.web.admin.service.impl;

import com.ldc.my.shop.web.admin.entity.User;
import com.ldc.my.shop.web.admin.mapper.UserMapper;
import com.ldc.my.shop.web.admin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * 实现登录接口
 * <p>Title: LoginServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/11/27 9:36
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String loginId, String loginPwd) {
        User params = new User();
        params.setUsername(loginId);
        params.setEmail(loginId);
        params.setPhone(loginId);

        User user = userMapper.getByLoginId(params);
        // 密码加密
        if (user != null) {
            // 判断密码是否正确
            if (loginPwd.equals(user.getPassword())) {
                return user;
            }
        }

        return null;
    }
}
