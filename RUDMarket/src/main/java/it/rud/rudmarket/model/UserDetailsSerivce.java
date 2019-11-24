package it.rud.rudmarket.model;

import it.rud.rudmarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsSerivce implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName);
        if(user==null)
            try {
                throw new UsernameNotFoundException("Not found: " + userName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return new UserDetailsImpl(user);
    }

}
