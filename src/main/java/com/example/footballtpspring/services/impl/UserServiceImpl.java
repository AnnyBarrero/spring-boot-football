package com.example.footballtpspring.services.impl;

import com.example.footballtpspring.pojos.User;
import com.example.footballtpspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User getUser(Long idUser) {
        return userDao.findById(idUser).orElse(null);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

}
