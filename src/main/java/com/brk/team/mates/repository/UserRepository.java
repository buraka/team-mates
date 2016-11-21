package com.brk.team.mates.repository;

import com.brk.team.mates.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
    
    List<User> findByFirstNameAndLastName(String firstName, String lastName);

    User findByUserName(String userName);
}