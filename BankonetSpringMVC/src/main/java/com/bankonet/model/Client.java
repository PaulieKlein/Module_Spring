package com.bankonet.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<CompteCourant> compteCourantList;
	@OneToMany(fetch=FetchType.EAGER)
	private List<CompteEpargne> compteEpargneList;
	
	@OneToMany(mappedBy="client")
	private List<Compte> compteList;

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
		return "\nClient : \nid : " + super.getId() +", Nom : " + super.getNom()
				+", Prénom : " + super.getPrenom() + ", login : " + login +", mot de passe : " + motdepasse
				 + adresse.toString()+"\n";
	}
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public List<CompteCourant> getCompteCourantList() {
		return Collections.unmodifiableList(compteCourantList);
	}

	

	public List<CompteEpargne> getCompteEpargneList() {
		return Collections.unmodifiableList(compteEpargneList);
	}

	
	public List<Compte> getCompteList() {
		return Collections.unmodifiableList(compteList);
	}

	public void setCompteList(List<Compte> compteList) {
		this.compteList = compteList;
	}
}
