package com.example.img302.module.user.contoller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.mac.Mac;
import com.example.img302.common.enums.UserType;
import com.example.img302.common.result.Result;
import com.example.img302.common.result.ResultUtil;
import com.example.img302.common.util.LoginUtil;
import com.example.img302.module.user.contoller.param.UserSignInParam;
import com.example.img302.module.user.contoller.param.UserSignUpParam;
import com.example.img302.module.user.model.User;
import com.example.img302.module.user.service.UserCacheService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;


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

    /**
     * 创建用户
     *
     * @param signUp 参数
     * @return 创建完的用户
     */
    @PostMapping("/user/sign-up")
    public Result<User> userSignUp(@RequestBody @Valid UserSignUpParam signUp) {
        // 判断用户名是否重复
        if (userCacheService.findUserByUserName(signUp.getUserName()) != null) {
            return ResultUtil.failed("msg-100000");
        }
        // 生成salt
        var uuid = IdUtil.fastSimpleUUID();
        var user = new User().setUserName(signUp.getUserName()).setPassword(LoginUtil.sha256Salt(signUp.getPassword(), uuid)).setUserType(UserType.COMMON).setSalt(uuid);
        userCacheService.saveUser(user);
        return ResultUtil.success();
    }

    /**
     * 登录接口
     *
     * @param signIn
     * @return
     */
    @PostMapping("/user/sign-in")
    public Result<SaTokenInfo> userSignIn(@RequestBody @Valid UserSignInParam signIn) {
        var user = userCacheService.findUserByUserName(signIn.getUserName());
        if (user == null) {
            return ResultUtil.failed("msg-100001");
        }
        // 判断密码是否正确
        var salt = LoginUtil.sha256Salt(signIn.getPassword(), user.getSalt());
        if (MessageDigest.isEqual(salt, user.getPassword())) {
            StpUtil.login(user.getId());
            return ResultUtil.data(StpUtil.getTokenInfo());
        } else {
            return ResultUtil.failed("msg-100002");
        }
    }


}
