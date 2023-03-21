package com.doctor.rest.Controller;

import com.doctor.rest.JWT.JWTUtility;
import com.doctor.rest.Models.User;
import com.doctor.rest.Models.LoginDTO.LoginDTO;
import com.doctor.rest.Models.LoginDTO.LoginResponse;
import com.doctor.rest.Repo.UserRepository;
import com.doctor.rest.Security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
//@EnableSwagger2
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private JWTUtility jwtUtility;

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @GetMapping("/logged")
    public String logged(){
        return "YOU'RE LOGGED!";
    }
    @PostMapping("/authenticate")
    @CrossOrigin()
    public LoginResponse authenticate(@RequestBody LoginDTO loginDTO) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getUsername(),
                            loginDTO.getPassword()
                    )
                   
            );
        } catch(BadCredentialsException ex) {
            throw new Exception("Credenciais erradas", ex);
        }
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginDTO.getUsername());
        final String token = jwtUtility.generateToken(userDetails);
        return new LoginResponse(token);


    }

    @PostMapping("/createUser")
    public User addUser(@RequestBody User user){
        passwordEncoder = new BCryptPasswordEncoder();
        User newUser = new User();
        newUser.setEmail(user.getEmail()); 
        newUser.setFirstName(user.getFirstName()); 
        newUser.setLastName(user.getLastName()); 
        newUser.setPassword(user.getEmail()); 
        newUser.setRole(user.getRole()); 
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setUsername(user.getUsername());
        return userRepository.save(newUser);
    }

}
