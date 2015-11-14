package com.draakasheeshah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.draakasheeshah.bo.UserEntity;
import com.draakasheeshah.dao.UserDAO;
import com.draakasheeshah.service.UserService;

@Service
public class UserServiceImpl
    implements UserService
{
    @Autowired
    UserDAO userDAO;

    public List<UserEntity> fetcUserList() {
        return userDAO.fetcUserList();
    }
}