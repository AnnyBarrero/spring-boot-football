package com.example.footballtpspring.services;

import com.example.footballtpspring.pojos.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    User getUser(Long idUser);
    List<User> getAllUser();

}
