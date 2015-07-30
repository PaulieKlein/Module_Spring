package com.bankonet.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Compte implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4523939384133386526L;

	@TableGenerator(name="yourTableGenerator",allocationSize=1)
	@Id @GeneratedValue(strategy=GenerationType.TABLE,generator="yourTableGenerator")
	private int identifiant=0;
	private String libelle;
	protected float solde;


	private Client client;
	/**
	 * Constructeur standard.
	 */
	
	Compte(){}
	
	
	Compte(String libelle, float solde) {

		this.libelle = libelle;
		this.solde = solde;

	}
	public abstract boolean creditAutorise(float montant)throws BankonetException;


	public abstract boolean debitAutorise(float montant)throws BankonetException;

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float newSolde) {
		this.solde = newSolde;
	}
	 public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}
}
