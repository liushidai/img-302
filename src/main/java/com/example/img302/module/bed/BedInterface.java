package com.example.img302.module.bed;

import com.example.img302.common.base.EntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author liushidai
 */
@Entity
@Getter
@Setter
public class BedInterface extends EntityBase implements Serializable {
    @Column(length = 32, nullable = false)
    private String type;
    @Column(length = 512, nullable = false)
    private String url;
}