package it.rud.rudmarket.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface RUDUserDetailsService extends UserDetailsService {
    boolean createUser(String username, String password);
}
