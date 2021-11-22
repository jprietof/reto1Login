package co.edu.usa.login.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.login.model.User;
import co.edu.usa.login.model.dao.IUser;
/**
 * 
 * @author jprietof
 *
 */

@Repository
public class RepositoryUser {
	@Autowired
	/**
	 * Connection Interface
	 */
	private IUser crudUser;
	/**
	 * List all user dataBase
	 * @return
	 */
	public List<User> getAll(){
		return (List<User>) crudUser.findAll();
	}
	/**
	 * Search for Id
	 * control of errors
	 * @param id
	 * @return
	 */
	public Optional<User> getUser(int id){
		return crudUser.findById(id);
	}
	public User save(User user) {
		return crudUser.save(user);
	}
	
	public boolean existeEmail(String email) {
		Optional<User> usuario = crudUser.findByEmail(email);
		return !usuario.isEmpty();
	}
	
	public Optional<User> autenticarUsuario(String email, String password){
		return crudUser.findByEmailAndPassword(email,password);
	}

}
