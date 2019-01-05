package com.ldc.my.shop.web.admin.abstracts.impl;

import com.google.common.collect.Maps;
import com.ldc.my.shop.web.admin.abstracts.AbstractBaseEntity;
import com.ldc.my.shop.web.admin.abstracts.BaseCrudService;
import com.ldc.my.shop.web.admin.abstracts.BaseMapper;
import com.ldc.my.shop.web.admin.commons.PageInfo;
import com.ldc.my.shop.web.admin.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * CRUD实现抽象类
 * @param <T>
 */
@Service
public abstract class AbstractBaseCrudServiceImpl <T extends AbstractBaseEntity,M extends BaseMapper<T>> implements BaseCrudService<T> {
    @Autowired
    protected M Mapper;

    @Override
    public void save(T entity) {
        if(entity.preInsert(entity)){
            Mapper.insert(entity);
        }
        else{
            Mapper.update(entity);
        }
    }

    @Override
    public List<T> selectAll() {
        return Mapper.selectAll();
    }

    @Override
    public PageInfo<T> page(T entity, int start, int length) {
        Map<String, Object> params = Maps.newHashMap();
        params.put(StringUtils.toUpperCaseFirstOne(entity.getClass().getSimpleName()), entity);
        params.put("start", start);
        params.put("length", length);

        List<T> data = Mapper.page(params);
        int total = count(entity);

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setData(data);
        pageInfo.setTotal(total);

        return pageInfo;
    }

    /**
     * 查询用户数量
     * @param entity
     * @return
     */
    @Override
    public int count(T entity) {
        return Mapper.count(entity);
    }

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    @Override
    public T getById(Long id) {
       return Mapper.getById(id);
    }

    /**
     * 通过id删除用户
     * @param id
     */
    @Override
    public void delete(Long id) {
       Mapper.delete(id);
    }
}
