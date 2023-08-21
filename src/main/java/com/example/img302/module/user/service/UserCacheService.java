package com.example.img302.module.user.service;

import com.example.img302.module.user.model.User;

/**
 * @author liushidai
 */
public interface UserCacheService {
    /**
     * 根据userName查询user
     *
     * @param userName 查询条件
     * @return user
     */
    User findUserByUserName(String userName);

    /**
     * 根据id删除user
     *
     * @param id user id
     */
    void deleteUserById(String id);

    /**
     * 新增保存
     *
     * @param user user
     * @return 保存后的
     */
    User saveUser(User user);
}
