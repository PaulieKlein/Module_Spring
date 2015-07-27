package com.bankonet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Personne implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7587089989187159432L;
	@TableGenerator(name="yourTableGenerator",allocationSize=1)
	@Id @GeneratedValue(strategy=GenerationType.TABLE,generator="yourTableGenerator")
	private Integer id;
	@Column(nullable = false)
	@Size(min = 3 , max = 60)
	private String nom;
	@Size(min = 3 , max = 60)
	private String prenom;

public Personne(){}
	
public Personne(String nom, String prenom){

		this.nom = nom;
		this.prenom = prenom;
		
	}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}
}
