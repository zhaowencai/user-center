package com.neo.usercenter.domain.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhaoyun
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 微信账号
     */
    @Column(name = "vx_id")
    private String vxId;

    /**
     * 微信昵称
     */
    @Column(name = "vx_nickname")
    private String vxNickname;

    /**
     * 角色
     */
    private String roles;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 积分
     */
    private Integer bonus;

    /**
     * 头像地址
     */
    @Column(name = "avatar_url")
    private String avatarUrl;
}