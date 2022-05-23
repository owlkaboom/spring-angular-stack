package com.owlkaboom.springangular.auth;

import com.owlkaboom.springangular.auth.model.FauxUser;
import com.owlkaboom.springangular.auth.model.RegisterDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    UserDetailsManager userDetailsManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = "/register")
    public void register(@RequestBody RegisterDTO registerDTO){
        if(StringUtils.isEmpty(registerDTO.getUsername()) || StringUtils.isEmpty(registerDTO.getPassword()) || StringUtils.isEmpty(registerDTO.getVerifyPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing username, password, or verify password");
        }

        if(!StringUtils.equals(registerDTO.getPassword(), registerDTO.getVerifyPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password and verify password do not match");
        }

        boolean userExists = userDetailsManager.userExists(registerDTO.getUsername());

        if(userExists){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        User user = new User(registerDTO.getUsername(), passwordEncoder.encode(registerDTO.getPassword()), authorities);
        userDetailsManager.createUser(user);

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @GetMapping("/user")
    public FauxUser getUser(Principal principal){
        return new FauxUser(principal.getName());
    }
}
