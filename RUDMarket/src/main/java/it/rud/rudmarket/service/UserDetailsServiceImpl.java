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
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(s);

		if (user == null) {
			return null;
		}

		return new UserDetailsImpl(user);
	}
}
