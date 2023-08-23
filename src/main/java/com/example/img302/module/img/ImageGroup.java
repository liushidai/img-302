package com.example.img302.module.img;

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
public class ImageGroup extends EntityBase implements Serializable {
    /**
     * User ID
     */
    @Column(nullable = false)
    private Integer userId;
    
    @Column(length = 32, nullable = false)
    private String name;

}
