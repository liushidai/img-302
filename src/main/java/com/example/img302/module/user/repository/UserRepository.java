package com.example.img302.module.user.repository;

import com.example.img302.module.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liushidai
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 根据userName查询user
     *
     * @param userName 查询条件
     * @return User
     */
    User findByUserName(String userName);
}
