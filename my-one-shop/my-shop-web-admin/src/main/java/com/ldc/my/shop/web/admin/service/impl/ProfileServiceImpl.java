package com.ldc.my.shop.web.admin.service.impl;

import com.ldc.my.shop.web.admin.constants.SystemConstants;
import com.ldc.my.shop.web.admin.entity.User;
import com.ldc.my.shop.web.admin.mapper.UserMapper;
import com.ldc.my.shop.web.admin.service.ProfileService;
import com.ldc.my.shop.web.admin.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

/**
 * 个人信息管理
 * <p>Title: ProfileServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/11/29 10:12
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        user.setUpdated(new Date());
        userMapper.update(user);
    }

    /**
     * 0/成功，1/旧密码错误，2/新密码不符合规范
     *
     * @param user
     * @return
     */
    @Override
    public int modifyPassword(User user) {
        // 获取当前用户实例
        User profile = userMapper.getById(user.getId());


        // 旧密码不正确
        if (!StringUtils.equals(profile.getPassword(), user.getOldPassword())) {
            return User.CHECK_FAIL_OLD_PASSWORD;
        }

        // 校验新密码
        if (StringUtils.isBlank(user.getNewPassword())) {
            return User.CHECK_FAIL_NEW_PASSWORD;
        }

        // 修改密码
        profile.setPassword(user.getNewPassword());
        userMapper.update(profile);

        return SystemConstants.RESULT_OK;
    }
}
