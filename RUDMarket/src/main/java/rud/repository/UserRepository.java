package rud.repository;


import rud.model.User;

public interface UserRepository {

	User findByUsername(String username);
}
