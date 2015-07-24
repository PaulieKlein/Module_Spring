package com.bankonet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@DiscriminatorValue("C")
public class Client extends Personne implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4358243889532510821L;
	@Column(nullable = false)
	@Size(min = 2 , max = 16)
	private String login;
	@Column(nullable = false)
	@Size(min = 6 , max = 50)
	private String motdepasse;
	
	@Autowired
	@Embedded
	private Adresse adresse;
	
	
	

	public Client(){}
	
	public Client( String nom, String prenom,String login, String motdepasse,Adresse adresse){
		super(nom,prenom);
		this.login = login;
		this.motdepasse = motdepasse;
		this.adresse = adresse;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String toString (){
		return "\nClient : \nid : " + super.getId() +"\nNom : " + super.getNom()
				+"\nPrénom : " + super.getPrenom() + "\nlogin : " + login +"\nmot de passe : " + motdepasse
				 + adresse.toString();
	}
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
}
