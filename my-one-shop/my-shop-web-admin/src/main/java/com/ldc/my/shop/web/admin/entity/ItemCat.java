package com.ldc.my.shop.web.admin.entity;

import com.ldc.my.shop.web.admin.abstracts.AbstractTreeBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ItemCat extends AbstractTreeBaseEntity {
           private String name;
           private Integer status;
           private Integer sortOrder;


}
