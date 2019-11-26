package it.rud.rudmarket.repository;

import it.rud.rudmarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
	User findByEmail(String email);
}
