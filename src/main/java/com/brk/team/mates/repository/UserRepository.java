package com.brk.team.mates.repository;

import com.brk.team.mates.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends CrudRepository<User, Long> {

    @PreAuthorize(value = "isAuthenticated()")
    List<User> findAll();

    User findByUserName(@Param(value = "userName") String userName);
}