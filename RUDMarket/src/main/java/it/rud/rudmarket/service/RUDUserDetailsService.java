package it.rud.rudmarket.service;

import it.rud.rudmarket.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface RUDUserDetailsService extends UserDetailsService {
    boolean createUser(String username, String password);
    List<String> getUserUsername();
    boolean upgradeRole(String username);
}
