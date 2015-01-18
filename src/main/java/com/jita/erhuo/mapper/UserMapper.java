package com.jita.erhuo.mapper;

import com.jita.erhuo.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by guitar on 15/1/17.
 */
@Component
public interface UserMapper{
//    public void insertUser(User user);

    public User getUserById(Long userId);

    public List<User> getAllUsers();

//    public void updateUser(User user);
//
//    public void deleteUser(Integer userId);
}
