package it.rud.rudmarket.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface RUDUserDetailsService extends UserDetailsService {
    boolean createUser(String email, String nome, String cognome, String ncarta, String password);
    List<String> getUserUsername();
    boolean upgradeRole(String username);
}
