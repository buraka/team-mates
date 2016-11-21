package com.brk.team.mates.controler.secured;

import com.brk.team.mates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/user")
public class UserContorller {

    @Autowired
    private UserService userService;

    @RequestMapping("/{userId}")
    public String hello(@PathVariable long userId) {
        return userService.find(userId).toString();
    }
}