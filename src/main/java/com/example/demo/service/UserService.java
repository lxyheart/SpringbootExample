package com.example.demo.service;

import com.example.demo.entity.User;

/**
 * Created by lixingyuan on 2018/5/9.
 */
public interface UserService {
   /* public User findByUsernameAanPassword(String username,String password);*/
    public User findByPassword(String password);
}
