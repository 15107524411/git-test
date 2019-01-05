package com.ldc.my.shop.web.admin.abstracts;

import java.util.List;

public interface BaseTreeCrudMapper <T extends AbstractTreeBaseEntity> extends BaseMapper<T>{

    List<T> getByParentId(Long parentId);
}
