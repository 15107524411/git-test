package com.ldc.my.shop.web.admin.abstracts;

import java.util.List;

public interface BaseTreeCrudService<T extends AbstractTreeBaseEntity> extends BaseCrudService<T> {
    List<T> getByParentId(Long parentId);
}
