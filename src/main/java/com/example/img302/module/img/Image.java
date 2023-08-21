package com.example.img302.module.img;

import com.example.img302.common.base.EntityBase;
import com.example.img302.module.user.model.User;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author liushidai
 */
@Entity
@Getter
@Setter
public class Image extends EntityBase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private User user;
    @ManyToOne(optional = false)
    private ImageGroup imageGroup;

    //    @Column(length = 32, nullable = false, unique = true, columnDefinition = "")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    /**
     * crc32
     */
    @Column(length = 10, nullable = false)
    private String crc32;

    @Column(length = 16, nullable = false, columnDefinition = "binary(16)")
    private byte[] md5;
    /**
     * 跳转路径
     */
    @Type(JsonType.class)
    @Column(columnDefinition = "json", nullable = false)
    private JumpHashMap jumpPath;
    /**
     * 本地路径
     */
    @Column(nullable = false)
    private String localPath;
    /**
     * 创建时间
     */
    @CreatedDate
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @LastModifiedDate
    private LocalDateTime updateTime;
}