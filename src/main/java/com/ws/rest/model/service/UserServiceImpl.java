package com.ws.rest.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.rest.model.entities.User;
import com.ws.rest.model.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService
{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) 
    {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmailAndPassword(String email, String password)
    {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User saveUser(User user) 
    {
        user.setActive("1");
        return userRepository.save(user);
    }

}