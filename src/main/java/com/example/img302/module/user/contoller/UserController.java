package com.example.img302.module.user.contoller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.img302.common.enums.UserType;
import com.example.img302.common.result.Result;
import com.example.img302.common.result.ResultUtil;
import com.example.img302.module.user.model.User;
import com.example.img302.module.user.service.UserCacheService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author liushidai
 */
@Slf4j
@RestController
@RequestMapping("/system")
public class UserController {
    private final UserCacheService userCacheService;

    public UserController(UserCacheService userCacheService) {
        this.userCacheService = userCacheService;
    }

    private static byte[] sha256Salt(String password, String salt) {
        var hMac = SecureUtil.hmacSha256(salt);
        return hMac.digest(password);
    }

    /**
     * 创建用户
     *
     * @param create 参数
     * @return 创建完的用户
     */
    @PostMapping("/user")
    public Result<User> saveUser(@RequestBody @Valid CreateUserParam create) {
        var userByUserName = userCacheService.findUserByUserName(create.getUserName());

        // 判断用户名是否重复
        if (userCacheService.findUserByUserName(create.getUserName()) != null) {
            return ResultUtil.failed("msg-100000");
        }

        // 生成salt
        var uuid = IdUtil.fastSimpleUUID();

        var user = new User().setUserName(create.getUserName()).setPassword(sha256Salt(create.getPassword(), uuid)).setUserType(UserType.ADMIN).setSalt(uuid);

        userCacheService.saveUser(user);

        return null;
    }

}
