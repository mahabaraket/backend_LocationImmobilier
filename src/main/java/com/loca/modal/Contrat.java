package com.loca.modal;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name = "Contrats")
public class Contrat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "contratname", unique = true)
	private String contratname;

	@Column(name = "dateDeb")
	private String dateDebut;

	@Column(name = "localisation")
	private String localisation;
	
	@Column(name = "dateFin")
	private String dateFin;
	
	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	private boolean contrat;

	
	public Contrat() {
		super();
	}


	public Contrat(long id, String contratname, String dateDebut, String localisation, String dateFin, String name,
			String email, boolean contrat) {
		super();
		this.id = id;
		this.contratname = contratname;
		this.dateDebut = dateDebut;
		this.localisation = localisation;
		this.dateFin = dateFin;
		this.name = name;
		this.email = email;
		this.contrat = contrat;
	}


	public String getContratname() {
		return contratname;
	}


	public void setContratname(String contratname) {
		this.contratname = contratname;
	}


	public String getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}


	public String getLocalisation() {
		return localisation;
	}


	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}


	public String getDateFin() {
		return dateFin;
	}


	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isContrat() {
		return contrat;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setContrat(boolean contrat) {
		this.contrat = contrat;
	}
	@OneToOne(mappedBy="contrat")
	private BienImmobilier BienImmobilier ;
	
	


	
}
