package com.example.img302.common.base;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author liushidai
 */

@MappedSuperclass
@Getter
@Setter
public class EntityBase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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