package com.jita.erhuo.service.impl;

import com.jita.erhuo.entity.User;
import com.jita.erhuo.mapper.UserMapper;
import com.jita.erhuo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by guitar on 15/1/18.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(Long id) {
        return userMapper.getUserById(id);
    }
}
