package com.example.img302.module.user.service.impl;

import com.example.img302.module.user.model.User;
import com.example.img302.module.user.repository.UserRepository;
import com.example.img302.module.user.service.UserCacheService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author liushidai
 */
@Service
@CacheConfig(cacheNames = "Cache::UserCache")
public class UserCacheServiceImpl implements UserCacheService {
    private final UserRepository userRepository;

    public UserCacheServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Cacheable(key = "#userName")
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void deleteUserById(String id) {

    }

    @Override
    @CacheEvict(key = "#user.userName")
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
