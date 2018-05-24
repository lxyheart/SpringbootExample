package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by lixingyuan on 2018/5/14.
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 缓存的key
     */
    public static final String THING_ALL_KEY   = "\"thing_all\"";
    /**
     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
     */
    public static final String DEMO_CACHE_NAME = "lemonCache";

    @Autowired
    UserMapper userMapper;
   /* @Override
    public User findByUsernameAanPassword(String username, String password) {
        return userMapper.findByUsernameAanPassword(username,password);
    }*/

    @Override
    //Cacheable如果缓存中有，则在缓存中取，否则再去操作数据库
    @Cacheable(value = DEMO_CACHE_NAME,key = THING_ALL_KEY)
    public User findByPassword(String password) {
        User user = userMapper.findByPassword(password);
        System.out.println("为id、key为:"+user.getPassword()+"数据做了缓存");
        return user;
    }
}
