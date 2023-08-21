package com.example.img302.module.user.model;

import com.example.img302.common.base.EntityBase;
import com.example.img302.common.enums.UserType;
import com.example.img302.common.enums.converter.UserTypeConverter;
import com.example.img302.module.img.Image;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author liushidai
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
public class User extends EntityBase implements Serializable {
    /**
     * 用户名
     */
    @Column(length = 32, nullable = false)
    private String userName;
    /**
     * 密码
     */
    @Column(length = 32, nullable = false, columnDefinition = "binary(32)")
    private byte[] password;
    /**
     * salt
     */
    @Column(length = 32, nullable = false, columnDefinition = "char(32)")
    private String salt;
    /**
     * 用户类型
     */
    @Convert(converter = UserTypeConverter.class)
    @Column(nullable = false)
    private UserType userType;
    /**
     * 上传的图片
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> images;
}
