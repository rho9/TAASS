package it.rud.rudmarket.service;

import it.rud.rudmarket.model.User;
import it.rud.rudmarket.model.UserDetailsImpl;
import it.rud.rudmarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public boolean createUser(String email, String nome, String cognome, String ncarta, String password) {
		Optional<User> userOptional = userRepository.findById(email);

		if (userOptional.isPresent()) {
			return false;
		}
		
		userRepository.saveAndFlush(new User(email, nome, cognome, 	ncarta, password, "user"));
		return true;
	}

	@Override
	public List<String> getUserUsername() {
		List<String> result = new ArrayList<>();
		List<User> users = userRepository.findAll();
		for(User u : users){
			result.add(u.getEmail());
		}
		return result;
	}

	@Override
	public boolean upgradeRole(String username) {
		User user = userRepository.findById(username).get();
		user.setRoles("admin");
		userRepository.saveAndFlush(user);
		return true;
	}
}
