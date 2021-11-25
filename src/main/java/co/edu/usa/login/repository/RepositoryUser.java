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
	    private IUser userCrudRepository;

	    public List<User> getAll() {
	        return (List<User>) userCrudRepository.findAll();
	    }

	    public Optional<User> getUser(int id) {
	        return userCrudRepository.findById(id);
	    }

	    public User save(User user) {
	        return userCrudRepository.save(user);
	    }

	    public boolean existeEmail(String email) {
	        Optional<User> usuario = userCrudRepository.findByEmail(email);

	        return !usuario.isEmpty();
	    }

	    public Optional<User> autenticarUsuario(String email, String password) {
	        return userCrudRepository.findByEmailAndPassword(email, password);
	    }
}
