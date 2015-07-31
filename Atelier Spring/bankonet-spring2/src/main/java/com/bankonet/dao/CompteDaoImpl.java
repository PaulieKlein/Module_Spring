package com.bankonet.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;

@Repository("compteDao")
public class CompteDaoImpl implements ICompteDao {
	
	@PersistenceContext
    private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void addCompteC(CompteCourant c,Integer id){	
		Client client = em.find(Client.class,id);
		c.setClient(client);
		client.getCompteCourantList().add(c);
		em.merge(client);
	}
	

	public List<Compte> listComptes(Client client,String type){
		List<Compte> comptes = new ArrayList<Compte>();
		try{
			if (type.equals("CC")){
		      String texteQuery1 = "Select c From CompteCourant as c JOIN Compte as co where type(co)=CompteCourant and co.client=:client ";
		      TypedQuery<Compte> query1 = em.createQuery(texteQuery1,Compte.class);
		      query1.setParameter("client",client);
		      comptes =  query1.getResultList();
			} 
			if (type.equals("CE")) {
				 String texteQuery1 = "Select c From CompteEpargne as c JOIN Compte as co where type(co)=CompteEpargne and co.client=:client ";
			      TypedQuery<Compte> query1 = em.createQuery(texteQuery1,Compte.class);
			      query1.setParameter("client",client);
			      comptes =  query1.getResultList();
			}
	  	} catch(Exception e){
	  		e.printStackTrace();
	  	} 
		return comptes;
	}
	
	public List<Compte> findAll(){
		List<Compte> comptes = new ArrayList<Compte>();
		try{
		      String texteQuery1 = "Select c From Compte as c";
		      TypedQuery<Compte> query1 = em.createQuery(texteQuery1,Compte.class);
		    
		      comptes =  query1.getResultList();
		     
	  	} catch(Exception e){
	  		e.printStackTrace();
	  	} 
		return comptes;
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void deleteCompte(int idClompte){
		Compte compte = em.find(Compte.class, idClompte); 
		em.remove(compte);
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public Compte editCompte(int idClompte){
		Compte compte = em.find(Compte.class, idClompte);
		return compte;
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void updateCompte(Compte c){
		Compte compte = em.find(Compte.class, c.getIdentifiant());
		if(compte!=null){
					
			em.merge(c);
		
		}else {System.out.println("Ce compte n'exite pas");}
	}
	@Transactional(propagation = Propagation.MANDATORY)
	public void transfertMontant(Compte cptSource, Compte cptDest, float montant){
		
		float solde1 = cptSource.getSolde()-montant;
		float solde2 = cptDest.getSolde()+montant;

		
		String textQuery1 = " update Compte  set solde=:solde1 where identifiant=:IdSource";
		TypedQuery<Compte> query1 = em.createQuery(textQuery1, Compte.class);
		query1.setParameter("solde1",solde1);
		query1.setParameter("IdSource",cptSource.getIdentifiant());
	      
		String textQuery2 = "update Compte set solde=:solde2 where identifiant=:IdDest";
		TypedQuery<Compte> query2 = em.createQuery(textQuery2, Compte.class);
		query2.setParameter("solde2",solde2);
		query2.setParameter("IdDest",cptDest.getIdentifiant());

		cptSource.setSolde(solde1);
        cptDest.setSolde(solde2);
        em.merge(cptSource);
        em.merge(cptDest);
	}
	
	public List<Compte> chercherCompte(Integer id){
		Client client = em.find(Client.class, id);
		List<Compte> comptes = new ArrayList<Compte>();
		try{
		      String texteQuery1 = "Select c From Compte as c where c.client=:client";
		      TypedQuery<Compte> query1 = em.createQuery(texteQuery1,Compte.class);
		      query1.setParameter("client", client);
		      comptes =  query1.getResultList();
		     
	  	} catch(Exception e){
	  		e.printStackTrace();
	  	} 
		return comptes;
		
	}
}
