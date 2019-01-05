package com.ldc.my.shop.web.admin.abstracts;

import com.ldc.my.shop.web.admin.commons.PageInfo;

import java.util.List;

public interface BaseCrudService<T extends AbstractBaseEntity> {
    /**
     * 查询全部实例
     */
    List<T> selectAll();

    /**
     * 分页查询
     * @param entity
     * @param start
     * @param length
     * @return
     */
    PageInfo<T > page(T entity, int start, int length);

    /**
     * 查询总笔数
     * @param entity
     * @return
     */
    int count(T entity);

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 修改或新增
     * @param entity
     */
    void save(T entity);
    /**
     * 删除用户
     * @param id
     */
    void delete(Long id);
}
