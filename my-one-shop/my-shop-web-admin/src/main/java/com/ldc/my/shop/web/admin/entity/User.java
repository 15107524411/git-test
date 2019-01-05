package com.ldc.my.shop.web.admin.entity;

import com.ldc.my.shop.web.admin.abstracts.AbstractBaseEntity;
import com.ldc.my.shop.web.admin.utils.RegexpUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

/**
 * 用户表
 * <p>Title: User</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/11/26 10:52
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends AbstractBaseEntity {
    /**
     * 表示旧密码验证失败
     */
    public static final int CHECK_FAIL_OLD_PASSWORD = 1;

    /**
     * 表示新密码不符合规范
     */
    public static final int CHECK_FAIL_NEW_PASSWORD = 2;

    @NotEmpty(message = "姓名不可为空")
    private String username;
    private String password;

    @NotEmpty(message = "手机号不可为空")
    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确")
    private String phone;

    @NotEmpty(message = "邮箱不可为空")
    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;

    // ---------------------------------------- 扩展属性 ----------------------------------------

    @Transient
    private String newPassword;

    /**
     * 用于修改密码时判断旧密码
     */
    @Transient
    private String oldPassword;


}
