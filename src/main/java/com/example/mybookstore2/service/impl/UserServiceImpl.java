package com.example.mybookstore2.service.impl;


import com.example.mybookstore2.entity.User;
import com.example.mybookstore2.mapper.UserMapper;
import com.example.mybookstore2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> queryList() {
        return userMapper.queryList();
    }

    @Override
    public User queryByName(String username) {
        return userMapper.queryByName(username);
    }

    @Override
    public List<User> searchNameList(String username) {
        return userMapper.searchNameList(username);
    }

    @Override
    public User queryById(Integer id) {
        return userMapper.queryById(id);
    }

    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return userMapper.queryAllByLimit(offset,limit);
    }

    @Override
    public User insert(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
    public User update(User user) {
        userMapper.update(user);
        return user;
    }

    @Override
    public boolean deleteById(Integer id){
        return userMapper.deleteById(id)>0;
    }

    @Override
    public User queryUser(User user) {
        return userMapper.queryUser(user);
    }

}
