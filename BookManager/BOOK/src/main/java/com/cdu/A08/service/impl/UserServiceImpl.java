package com.cdu.A08.service.impl;

import com.cdu.A08.dao.UserDao;
import com.cdu.A08.dao.impl.UserDaoImpl;
import com.cdu.A08.entity.User;
import com.cdu.A08.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        if (userDao.queryUserByUsername(username)==null){
            return false;
        }
        return true;
    }
}
