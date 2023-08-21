package com.example.img302.module.bed;

import com.example.img302.common.base.EntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author liushidai
 */
@Entity
@Getter
@Setter


public class Bed extends EntityBase implements Serializable {
    /**
     * bed name
     */
    @Column(length = 32, nullable = false)
    private String name;

    /**
     * 级联保存、更新、删除、刷新;延迟加载。当删除Bed，会级联删除Bed的所有BedInterface
     * 拥有mappedBy注解的实体类为关系被维护端
     * mappedBy="bed"中的bed是BedInterface中的Bed属性
     */
    @OneToMany(mappedBy = "bed", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BedInterface> bedInterfaces;
}