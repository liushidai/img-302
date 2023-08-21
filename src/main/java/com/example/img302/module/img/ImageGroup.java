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
    @Column(length = 32, nullable = false)
    private String name;

    @OneToMany(mappedBy = "imageGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> images;
}
