package it.rud.rudmarket.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface RUDUserDetailsService extends UserDetailsService {
    void createUser(String username, String password);
}
