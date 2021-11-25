package co.edu.usa.login.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author jprietof
 *
 */
@Entity
@Getter
@Setter
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NonNull
	@Column(name="user_email",nullable=false, unique=true, length=50)
	private String email;
	@NonNull
	@Column(name="user_password",nullable=false, length=50)
	private String password;
	@NonNull
	@Column(name="user_name", nullable=false, length=80)
	private String name;
	public User(String email2, String password2, String string) {
		// TODO Auto-generated constructor stub
	}
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
}
