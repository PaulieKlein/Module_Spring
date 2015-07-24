package com.bankonet.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Client extends Personne{
	private String login;
	private String motdepasse;
	
	
	@Autowired
	private Adresse adresse;
	
	
	public Client(){}
	
	public Client(Integer id, String nom, String prenom,String login, String motdepasse){
		super(id,nom,prenom);
		this.login = login;
		this.motdepasse = motdepasse;
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
		return "Client : \nid : " + super.getId() +"\nNom : " + super.getNom()
				+"\nPrénom : " + super.getPrenom() + "\nlogin : " + login +"\nmot de passe : " + motdepasse
				 + adresse.toString();
	}
}
