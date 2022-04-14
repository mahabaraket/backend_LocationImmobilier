package com.loca.modal;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BienImmobilier")
public class BienImmobilier implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id")
	private long id;
	
	@Column(name = "proprietaire")
	private String proprietaire;

	@Column(name = "typologie")
	private String typologie;
	
	@Column(name = "superficie")
	private String superficie;
	
	public String getSuperficie() {
		return superficie;
	}

	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}

	@Column(name = "Composition")
	private String Composition;
	
	public String getComposition() {
		return Composition;
	}

	public void setComposition(String compostion) {
		Composition = compostion;
	}

	@Column(name = "etage")
	private String etage;

	@Column(name = "adress")
	private String adress;
	
	 @Lob
	 @Column(name = "picbyte")
	    private byte[] picbyte;
	 
	 @Column(name = "prix")
		private float prix;
	 
	 @Column(name = "etat")
		private Boolean etat;
	 
	 @OneToOne
	 @JoinColumn(name="contrat")
	 private Contrat contrat ;
	 


		//@OneToMany(mappedBy = "rec")
		//private ArrayList <BienImmobilier>  Bien = new ArrayList<BienImmobilier>();

	
	public byte[] getPicbyte() {
		return picbyte;
	}

	public void setPicbyte(byte[] picbyte) {
		this.picbyte = picbyte;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public String getTypologie() {
		return typologie;
	}

	public void setTypologie(String typologie) {
		this.typologie = typologie;
	}

	public String getEtage() {
		return etage;
	}

	public void setEtage(String etage) {
		this.etage = etage;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	@OneToMany(mappedBy = "BienImmobilier")
	private List <Reclamation> rec = new ArrayList<Reclamation>();



}
