package co.edu.usa.login.model.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.login.model.User;

public interface IUser extends CrudRepository<User, Integer>{
	Optional<User> findByEmail(String email);
	Optional<User> findByEmailAndPassword(String email, String password);
}
