package com.rud.rudmarket.controller;

import com.rud.rudmarket.exception.ResourceNotFoundException;
import com.rud.rudmarket.model.User;
import com.rud.rudmarket.repository.UserRepository;
import com.rud.rudmarket.security.CurrentUser;
import com.rud.rudmarket.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    @RequestMapping("/findUtenti")
    @PreAuthorize("hasRole('ADMIN')")
    public List<String> findUtenti(@RequestBody String body) {
        List<String> result = new ArrayList<>();

        for (User u : userRepository.findAll()) {
            if (u.getEmail().contains(body)) {
                result.add(u.getEmail());
            }
        }

        return result;
    }
}
