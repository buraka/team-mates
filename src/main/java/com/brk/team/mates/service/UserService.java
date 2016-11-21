package com.brk.team.mates.service;

import com.brk.team.mates.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User find(long userId);
}
