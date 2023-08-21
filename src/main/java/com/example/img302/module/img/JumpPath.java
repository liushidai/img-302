package com.example.img302.module.img;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liushidai
 */
@Data
public class JumpPath implements Serializable {
    /**
     * 路径
     */
    private String path;
    /**
     * 状态
     */
    private String status;
    /**
     * bedId
     */
    private String bedId;
}
