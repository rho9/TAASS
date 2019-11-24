package it.rud.rudmarket.repository;

import it.rud.rudmarket.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public abstract class UserRepositoryImpl implements UserRepository {
	@Override
	public User findByUsername(String username) {
		List<User> users = this.getUsers();

		for (User u : users) {
			if (u.getUsername().equals(username)) {
				return u;
			}
		}

		return null;
	}

	private List<User> getUsers() {
		List<User> users = new ArrayList<>();

		users.add(new User("Davide", "ciao", "admin"));
		users.add(new User("Rosita", "ciao", "admin"));
		users.add(new User("Umberto", "ciao", "user"));

		return users;
	}
}
