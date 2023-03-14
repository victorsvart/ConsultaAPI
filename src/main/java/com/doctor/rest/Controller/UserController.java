package com.doctor.rest.Controller;

import com.doctor.rest.Models.User;
import com.doctor.rest.Repo.UserRepository;
import com.doctor.rest.Services.eServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;

@RestController
@EnableSwagger2
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private eServices services;

    @PostMapping("addUser")
    public User addUser(User user){
        return services.addUser(user);
    }
    @GetMapping("getUser")
    public Optional<User> getUser(String username){
        return services.getUser(username);
    }
}
