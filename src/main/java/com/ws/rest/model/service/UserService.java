package com.ws.rest.model.service;

import com.ws.rest.model.entities.User;

public interface UserService 
{
 
    public User findByEmailAndPassword(String email, String password);

    public User saveUser(User user);

}