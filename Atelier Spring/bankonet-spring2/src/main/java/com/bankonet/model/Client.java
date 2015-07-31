package com.bankonet.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL,mappedBy="client")
	private List<CompteCourant> compteCourantList = new ArrayList<CompteCourant> ();
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL,mappedBy="client")
	private List<CompteEpargne> compteEpargneList = new ArrayList<CompteEpargne> ();

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

	public String toString(){
		return "\nClient : \nid : " + super.getId() +", Nom : " + super.getNom()
				+", Prénom : " + super.getPrenom() + ", login : " + login +", mot de passe : " + motdepasse
				 + adresse+"\n";
	}
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setCompteCourantList(List<CompteCourant> compteCourantList) {
		this.compteCourantList = compteCourantList;
	}

	public void setCompteEpargneList(List<CompteEpargne> compteEpargneList) {
		this.compteEpargneList = compteEpargneList;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public List<CompteCourant> getCompteCourantList() {
		return compteCourantList;
	}

	public List<CompteEpargne> getCompteEpargneList() {
		return compteEpargneList;
	}

	public void ajouterCompteCourant(CompteCourant c) {
		this.getCompteCourantList().add(c);
		c.setClient(this);
	}
	
	public void ajouterCompteEpargne(CompteEpargne c) {
		this.getCompteEpargneList().add(c);
		c.setClient(this);
	}

	public void modifierCompteCourant(CompteCourant compte){
		List<CompteCourant> liste = this.getCompteCourantList();
		Iterator<CompteCourant> compteIte = liste.iterator();
	    while (compteIte.hasNext()) {
            Compte c = (Compte) compteIte.next();
            if (c.getIdentifiant() == compte.getIdentifiant())
            	compteIte.remove();
            	
        }
	    liste.add(compte);
	}
	
	public void modifierCompteEpargne(CompteEpargne compte){
		List<CompteEpargne> liste = this.getCompteEpargneList();
		Iterator<CompteEpargne> compteIte = liste.iterator();
	    while (compteIte.hasNext()) {
            Compte c = (Compte) compteIte.next();
            if (c.getIdentifiant() == compte.getIdentifiant())
            	compteIte.remove();
            	
        }
	    liste.add(compte);
	}
	
	public List<Compte> getComptes() {
	    List<Compte> compteList = new ArrayList<Compte>();
	    compteList.addAll(compteCourantList);
	    compteList.addAll(compteEpargneList);
	    return compteList;

	}
	
	public Compte getCompte(int compteId){
		List<Compte> compteList = this.getComptes();
	    Iterator<Compte> compteIte = compteList.iterator();
	    while (compteIte.hasNext()) {
            Compte compte = (Compte) compteIte.next();
            if (compteId == compte.getIdentifiant())
                return compte;
        }
	    return null;
	}
}
