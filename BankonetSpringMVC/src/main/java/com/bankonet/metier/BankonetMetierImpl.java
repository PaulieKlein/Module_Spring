package com.bankonet.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.dao.IClientDao;
import com.bankonet.dao.ICompteDao;
import com.bankonet.model.BankonetException;
import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.Virement;

@Service("metier")
public class BankonetMetierImpl implements IBankonetMetier {
	
	@Resource(name="clientDao")
	private IClientDao clientDao;
	
	@Resource(name="compteDao")
	private ICompteDao compteDao;
	
	@Transactional(rollbackFor=Exception.class)
	public void addClient(Client c) throws Exception{
		clientDao.addClient(c);			
	}
	
	@Transactional(readOnly=true)
	public List<Client> listClients(){
		
		return clientDao.listClients();
	}
	@Transactional
	public void deleteClient(Integer idClient){
		clientDao.deleteClient(idClient);
	}
	@Transactional
	public Client editClient(Integer idClient){
		return clientDao.editClient(idClient);
	}
	@Transactional
	public void updateClient(Client c){
		clientDao.updateClient(c);
	}
	@Transactional
	public List<Client> chercherClients(String motCle){
		return clientDao.chercherClients(motCle);
	}
	@Transactional
	public List<Client> SupprimerClientDontLeNomContient(String motCle){
		for(Client c : clientDao.chercherClients(motCle)){
			clientDao.deleteClient(c.getId());
		}
		return clientDao.listClients();
	}
	
	@Transactional
	public void addCompteC(CompteCourant c,Integer id){
		compteDao.addCompteC(c,id);
	}

	public List<Compte> listComptes(Client client,String type){
		
		return compteDao.listComptes(client,type);
		
	}
	
	@Transactional
	public void deleteCompte(int idClompte){
		compteDao.deleteCompte(idClompte);
	}
	
	@Transactional
	public Compte editCompte(int idClompte){
		
		return compteDao.editCompte(idClompte);
	}
	
	@Transactional
	public void updateCompte(Compte c){
		compteDao.updateCompte(c);
	}
	
	public List<Compte> findAll(){
		return compteDao.findAll();
	}
	
	@Transactional
	public Virement effectuerVirement(Compte cptSource, Compte cptDest, float montant){
		float cptSourceSoldeOrigine = cptSource.getSolde();
        float cptDestSoldeOrigine = cptDest.getSolde();
        try {
            if (cptSource.getIdentifiant() == cptDest.getIdentifiant()) {
                throw new BankonetException("les deux comptes doivent être différents");
            }

            if (cptSource.debitAutorise(montant) && (cptDest.creditAutorise(montant))) {
                compteDao.transfertMontant(cptSource, cptDest, montant);
            }
        } catch (BankonetException e) {
            cptSource.setSolde(cptSourceSoldeOrigine);
            cptDest.setSolde(cptDestSoldeOrigine);
            // Lancer une exception
            e.printStackTrace();
        }
		return new Virement(cptSource, cptDest, montant);
	}
}
