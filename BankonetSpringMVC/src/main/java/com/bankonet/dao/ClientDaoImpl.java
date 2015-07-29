package com.bankonet.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import com.bankonet.model.Client;
import com.bankonet.model.Compte;

@Repository("clientDao")

public class ClientDaoImpl implements IClientDao {

	@PersistenceContext
    private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void addClient( Client c) throws Exception{
		em.persist(c);
	
	}
	@Transactional(readOnly=true,propagation = Propagation.MANDATORY)
	public List<Client> listClients(){
		List<Client> clients = new ArrayList<Client>();
		try{
		      String texteQuery1 = "Select c From Client as c";
		      TypedQuery<Client> query1 = em.createQuery(texteQuery1,Client.class);
		      clients =  query1.getResultList();
		     
	  	} catch(Exception e){
	  		e.printStackTrace();
	  	} 
		return clients;
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void deleteClient(Integer idClient){
		Client client = em.find(Client.class, idClient); 
		em.remove(client);
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public Client editClient(Integer idClient){
		Client client = em.find(Client.class, idClient);
		return client;
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void updateClient(Client c){
		Client client = em.find(Client.class, c.getId());
			if(client!=null){
						
				em.merge(c);
			
			}else {System.out.println("Ce client n'exite pas");}
					
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public List<Client> chercherClients(String motCle){
		String texteQuery = "Select c From Client as c where c.nom like :motCle or c.prenom like :motCle";
	      Query query = em.createQuery(texteQuery);
	      query.setParameter("motCle","%"+motCle+"%");
	      List<Client> listeClients = (List<Client>) query.getResultList();
	     
	      return listeClients;
	}
	

	
}
