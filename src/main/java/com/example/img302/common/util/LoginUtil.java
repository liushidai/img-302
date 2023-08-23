package com.example.img302.common.util;

import cn.hutool.crypto.SecureUtil;

/**
 * @author liushidai
 */
public class LoginUtil {
    public static byte[] sha256Salt(String password, String salt) {
        return SecureUtil.hmacSha256(salt).digest(password);
    }
}
