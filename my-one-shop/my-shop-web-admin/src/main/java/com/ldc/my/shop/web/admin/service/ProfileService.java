package com.ldc.my.shop.web.admin.service;

import com.ldc.my.shop.web.admin.entity.User;

/**
 * 个人信息管理
 * <p>Title: ProfileService</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/11/29 10:11
 */
public interface ProfileService {
    /**
     * 保存
     * @param user
     * @return
     */
    void save(User user);

    /**
     * 修改密码
     * @return 0/成功，1/旧密码错误，2/新密码与旧密码一致，3/新密码不符合规范
     */
    int modifyPassword(User user);
}
