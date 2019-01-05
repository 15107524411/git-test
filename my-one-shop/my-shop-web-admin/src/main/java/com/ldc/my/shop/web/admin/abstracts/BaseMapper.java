package com.ldc.my.shop.web.admin.abstracts;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BaseMapper <T extends AbstractBaseEntity>{
    /**
     * 根据ID获取实例
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 根据登录账号获取用户实例
     * 账号包括：username、phone、email
     *
     * @param entity
     * @return
     */
    T getByLoginId(T entity);

    /**
     * 更新
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 查询全部实例
     * @return
     */
    List<T> selectAll();

    /**
     * 分页查询
     * @param params 查询参数
     * @return
     */
    List<T> page(Map<String, Object> params);

    /**
     * 查询总笔数
     * @param entity
     * @return
     */
    int count(T entity);

    /**
     * 新增用户
     * @param entity
     */
    void insert(T entity);

    /**
     * 删除用户
     * @param id
     */
    void delete(Long id);
}
