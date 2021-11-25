package co.edu.usa.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.login.model.User;
import co.edu.usa.login.repository.RepositoryUser;

import java.util.*;
/**
 * 
 * @author jprietof
 *
 */
@Service
public class ServiceUser {
	@Autowired
	private RepositoryUser methodCrud;
	
	public List<User> getAll(){
		return methodCrud.getAll();
	}
	
	public Optional<User> getUser(int id){
		return methodCrud.getUser(id);
	}
	
	public User registrar(User user) {
		if(user.getId()==null) {
			if (existeEmail(user.getEmail()) == false) {
				return methodCrud.save(user);
			}else{
				return user;
			}
		}else {
			return user;
		}
	}
	
	public boolean existeEmail(String email) {
		return methodCrud.existeEmail(email);
	}
	
	public User autenticarUsuario(String email, String password) {
		Optional<User> usuario = methodCrud.autenticarUsuario(email, password);
		if(usuario.isEmpty()) {
			return new User(email, password, "NO DEFINIDO");
		}else {
			return usuario.get();
		}
	}
}
