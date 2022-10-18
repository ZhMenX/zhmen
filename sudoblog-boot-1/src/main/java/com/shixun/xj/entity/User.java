package com.shixun.xj.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhMen
 * @createTime 2022/9/19 9:04
 * @ClassName user
 * @Version v1.0
 * @Description
 */
@Data
@Entity(name = "sys_User")
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -40356785423868312L;

    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    /**
     * 主键
     */
    @Id
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 密码
     */
    private String password;
    /**
     * 账号状态（0正常 1停用）
     */
    private String status;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phonenumber;
    /**
     * 用户性别（0男，1女，2未知）
     */
    private String sex;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 用户类型（0管理员，1普通用户）
     */
    private String userType;
    /**
     * 创建人的用户id
     */
    private Long createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private Long updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    private Integer delFlag;
}
