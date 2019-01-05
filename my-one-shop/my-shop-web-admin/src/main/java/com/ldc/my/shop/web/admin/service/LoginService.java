package com.ldc.my.shop.web.admin.service;

import com.ldc.my.shop.web.admin.entity.User;

/**
 * 定义登录接口
 * <p>Title: LoginService</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/11/27 9:35
 */
public interface LoginService {
    /**
     * 登录
     * @param loginId 登录账号
     * @param loginPwd 登录密码
     * @return
     */
    User login(String loginId, String loginPwd);
}
