package com.ldc.my.shop.web.admin.abstracts.impl;

import com.ldc.my.shop.web.admin.abstracts.AbstractTreeBaseEntity;
import com.ldc.my.shop.web.admin.abstracts.BaseTreeCrudMapper;
import com.ldc.my.shop.web.admin.abstracts.BaseTreeCrudService;

import java.util.List;

public abstract class AbstractTreeBaseCrudServiceImpl<T extends AbstractTreeBaseEntity,M extends BaseTreeCrudMapper<T>> extends AbstractBaseCrudServiceImpl<T,M>implements BaseTreeCrudService<T> {
    @Override
    public List<T> getByParentId(Long parentId) {
        return Mapper.getByParentId(parentId);
    }
}
