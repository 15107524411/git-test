package com.ldc.my.shop.web.admin.abstracts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class AbstractTreeBaseEntity extends AbstractBaseEntity {
    private Long parentId;
    @JsonProperty(value="isParent")
    private boolean isParent;
    @Transient
    private String parentName;

}
