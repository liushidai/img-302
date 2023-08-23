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
}