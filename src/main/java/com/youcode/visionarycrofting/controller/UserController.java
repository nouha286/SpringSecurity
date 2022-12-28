package com.youcode.visionarycrofting.controller;


import com.youcode.visionarycrofting.entity.User;
import com.youcode.visionarycrofting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "visionarycrofting/User")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUsers()
    {
        return  userService.getUsers();
    }

    @PostMapping("/saveUser")
    public  User saveUser(@RequestBody User user)
    {
        return  userService.saveUser(user);
    }


}
