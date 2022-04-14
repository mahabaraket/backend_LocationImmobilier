package com.loca.modal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id")
	private long id;
	
	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "_password")
	private String password;

	@Column(name = "role")
	private String role;
	
	@Column(name = "Specialite")
	private String Specialite;

	public String getSpecialite() {
		return Specialite;
	}

	public void setSpecialite(String specialite) {
		Specialite = specialite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@OneToMany(mappedBy = "user")
	private List <Reclamation> reclamation = new ArrayList<Reclamation>();

	@OneToMany(mappedBy = "UserDemande")
	private List <DemandeLocation> demandes = new ArrayList<DemandeLocation>();


	


	
}
