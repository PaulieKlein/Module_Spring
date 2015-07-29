package com.bankonet.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;





import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.bankonet.model.Compte;





public class Test implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	public static void main(String[] args) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("My_PU");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = null;
	    
	      em = emf.createEntityManager();
	      
	      //Query 4
	     tx.begin();
	     String type = "CC";
	     List<Compte> comptes = new ArrayList<Compte>();
	     if (type.equals("CC")){
		      String texteQuery1 = "Select c.compteCourantList From Client as c JOIN Compte as co where type(co)=CompteCourant and c=:client ";
		      TypedQuery<Compte> query1 = em.createQuery(texteQuery1,Compte.class);
		      //query1.setParameter("client",client);
		      comptes =  query1.getResultList();
			} 
	     tx.commit();
	     
	      
	      
	}

}

