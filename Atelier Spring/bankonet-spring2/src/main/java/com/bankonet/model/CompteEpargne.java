package com.bankonet.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4501718256280161800L;

	private float tauxInteret;

    private float plafond;


	/**
     * @param id
     * @param libelle
     * @param solde
     * @param tauxInteret
     * @param plafond
     */
    
    public CompteEpargne() {
    	super();
    }
    
    

	public CompteEpargne(String libelle, float solde,
            float tauxInteret, float plafond) {
        super(libelle, solde);
        this.tauxInteret = tauxInteret;
        this.plafond = plafond;
    }

    /**
     * Le montant ne doit pas etre superieur au plafond de credit autorise
     * en une fois
     */
    public boolean creditAutorise(float montant) throws BankonetException {
        if (montant < getPlafond()) {
            return true;
        } else {
            throw new BankonetException("Le compte epargne "+ this.getIdentifiant() + " a pour plafond de credit : " + this.getPlafond());
        }
    }

    public boolean debitAutorise(float montant) throws BankonetException {
        if (getSolde() - montant >= 0) {
            return true;
        } else {
            throw new BankonetException("Montant trop eleve : le solde du compte epargne "+ this.getIdentifiant() + " ne peut etre negatif" );
        }
    }



    /**
     * Accesseur de la propriete <code>plafond</code>.
     * 
     * @return float
     */
    public float getPlafond() {
        return plafond;
    }

    /**
     * Mutateur de la propriete <code>plafond</code>.
     * 
     * @param newPlafond
     *            Nouveau plafond
     */
    public void setPlafond(float newPlafond) {
        plafond = newPlafond;
    }

    /**
     * Accesseur de la propriete <code>tauxInterêt</code>.
     * 
     * @return float
     */
    public float getTauxInteret() {
        return tauxInteret;
    }

    /**
     * Mutateur de la propriete <code>tauxInteret</code>.
     * 
     * @param newTauxInteret
     *            Nouveau taux d'interet
     */
    public void setTauxInteret(float newTauxInteret) {
        tauxInteret = newTauxInteret;
    }
	
  
}
