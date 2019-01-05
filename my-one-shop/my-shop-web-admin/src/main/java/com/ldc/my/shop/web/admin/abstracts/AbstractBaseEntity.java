package com.ldc.my.shop.web.admin.abstracts;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的基类
 * <p>Title: AbstractBaseEntity</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/11/30 10:28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractBaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date updated;

    public  boolean preInsert(AbstractBaseEntity entity){
        Date date = new Date();
        entity.setUpdated(date);
        if (entity.getId()==null){
            entity.setCreated(date);
            return true;
        }
        return false;
    }
}
