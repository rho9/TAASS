package it.rud.rudmarket.repository;


import it.rud.rudmarket.model.User;

public interface UserRepository {
	User findByUsername(String username);
}
