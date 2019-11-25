package it.rud.rudmarket.service;

import it.rud.rudmarket.model.User;
import it.rud.rudmarket.model.UserDetailsImpl;
import it.rud.rudmarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// classe che implementa la logica di recupero delle info dello user dal database (per ora è fittizio)
@Service(value = "udsi")
public class RUDUserDetailsServiceImpl implements RUDUserDetailsService {

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

	@Override
	public void createUser(String username, String password) {
		userRepository.saveAndFlush(new User(username, password, "user"));
	}
}
