package com.loca.modal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "Reclamations")
public class Reclamation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id")
	private long id;
	
	
	

	@Column(name = "_type")
	private String type;

	@Column(name = "_description")
	private String description;

	@Column(name = "_date")
	private String date;
	
	@Column(name = "_photo")
	private String photo;
	
	@Column(name = "_status")
	private boolean status;

	
	
	public Reclamation() {
		super();
	}

	public Reclamation(String objet, String type, String description,String photo, String date, boolean status) {
		super();
		this.photo=photo;
		this.type = type;
		this.description = description;
		this.date = date;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription( ) {
		return description;
	}

	
	public void setstatus(boolean status) {
		this.status = status;
	}
	public boolean getstatus( ) {
		return status;
	}
	@ManyToOne
	@JoinColumn(name="id_Bien")
	private  BienImmobilier BienImmobilier ;
	
 
	
	@ManyToOne
	@JoinColumn(name="User")
	private User user  ;
	
}
