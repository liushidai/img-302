package com.example.img302.module.user.contoller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liushidai
 */
@Data
public class CreateUserParam implements Serializable {
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
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$", message = "至少1个大写字母，1个小写字母和1个数字")
    @Size(min = 8, message = "password长度必须在10~20之间")
    private String password;
}
