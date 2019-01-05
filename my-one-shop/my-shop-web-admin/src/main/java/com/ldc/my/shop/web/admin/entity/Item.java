package com.ldc.my.shop.web.admin.entity;

import com.ldc.my.shop.web.admin.abstracts.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;

@Data
@EqualsAndHashCode(callSuper=false)
public class Item extends AbstractBaseEntity {
    private String title;
    private String sellPoint;
    private Long price;
    private Integer num;
    private String barcode;
    private String image;
    private Long cid;
    private Integer status;

    @Transient
    private String cname;

   @Transient
    private ItemDesc itemDesc;

}
