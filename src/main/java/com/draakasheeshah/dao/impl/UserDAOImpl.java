package com.draakasheeshah.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.draakasheeshah.bo.UserEntity;
import com.draakasheeshah.dao.UserDAO;

@Repository
public class UserDAOImpl
    implements UserDAO
{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public List<UserEntity> fetcUserList() {
        List<UserEntity> userList = null;
        userList = hibernateTemplate.loadAll(UserEntity.class);
        return userList;
    }
}

// http://www.javatpoint.com/hibernate-and-spring-integration