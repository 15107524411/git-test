package com.ldc.my.shop.web.admin.service.impl;

import com.ldc.my.shop.web.admin.abstracts.impl.AbstractBaseCrudServiceImpl;
import com.ldc.my.shop.web.admin.entity.User;
import com.ldc.my.shop.web.admin.mapper.UserMapper;
import com.ldc.my.shop.web.admin.service.UserService;
import com.ldc.my.shop.web.admin.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends AbstractBaseCrudServiceImpl<User,UserMapper> implements UserService {
    @Autowired
    private UserMapper userMapper;


    /**
     * 新增和修改
     * @param user
     */
    @Override
    public void save(User user) {
            // 新增
            if (user.preInsert(user)) {
                user.setPassword(user.getPassword());
                userMapper.insert(user);
            }

            // 编辑
            else {
                // 密码为空则需设置原密码
                if (StringUtils.isBlank(user.getPassword())) {
                    User oloUser = getById(user.getId());
                    user.setPassword(oloUser.getPassword());
                }

                // 修改后的密码
                else {
                    user.setPassword(user.getPassword());
                }

                userMapper.update(user);
            }
    }


}
