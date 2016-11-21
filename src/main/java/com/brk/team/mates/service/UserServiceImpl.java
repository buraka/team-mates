package com.brk.team.mates.service;

import com.brk.team.mates.model.User;
import com.brk.team.mates.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User find(long userId) {
        return userRepository.findOne(userId);
    }
}
