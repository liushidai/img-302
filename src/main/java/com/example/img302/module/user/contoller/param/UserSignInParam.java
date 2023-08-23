package com.example.img302.module.user.contoller.param;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liushidai
 */
@Data
public class UserSignInParam implements Serializable {
    /**
     * 用户名
     */
    @NotBlank
    @Size(min = 10, max = 20, message = "userName长度必须在10~20之间")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "username只允许字母、数字")
    private String userName;
    /**
     * 密码
     * <p>
     */
    @NotBlank
    private String password;
}
