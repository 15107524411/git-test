package com.ldc.my.shop.web.admin.entity;

import com.ldc.my.shop.web.admin.abstracts.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ItemDesc extends AbstractBaseEntity {
    private Long itemId;
    private String itemDesc;

}
