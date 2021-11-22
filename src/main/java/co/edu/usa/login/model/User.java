package co.edu.usa.login.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author jprietof
 *
 */
@Entity
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
	@Column(nullable=false, unique=true, length=50)
	private String email;
	@Column(nullable=false, length=50)
	private String password;
	@Column(name="first_name", nullable=false, length=80)
	private String name;
}
