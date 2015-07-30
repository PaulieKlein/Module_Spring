package com.bankonet.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9088161793555478061L;
	private float decouvertAutorise;


	public CompteCourant(){
		super();
	}


	public CompteCourant(String libelle, float solde,
            float decouvertAutorise) {

        super(libelle, solde);

        this.decouvertAutorise = decouvertAutorise;
    }

    /**
     * Le credit d'un compte courant est toujours autorise
     */
    public boolean creditAutorise(float montant){
        return true;
    }

    public boolean debitAutorise(float montant) throws BankonetException {
        if (this.getSolde() + this.getDecouvertAutorise() >= montant) {
            return true;
        } else {
            throw new BankonetException("Montant trop eleve : le solde du compte courant "+ this.getIdentifiant() + " ne peut descendre en dessous du decouvert autorise" );
                   }
    }

    /**
     * Accesseur de la propriete <code>decouvertAutorise</code>.
     * 
     * @return float
     */
    public float getDecouvertAutorise() {
        return decouvertAutorise;
    }
   
	

	public void setDecouvertAutorise(float decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}
}
