package com.bankonet.metier;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.bankonet.dao.IClientDao;
import com.bankonet.model.Client;

@Service("metier")
public class BankonetMetierImpl implements IBankonetMetier {
	
	@Resource(name="clientDao")
	private IClientDao clientDao;
	
	public void addClient(Client c){
		clientDao.addClient(c);
	}
	public List<Client> listClients(){
		
		return clientDao.listClients();
	}
	public void deleteClient(Integer idClient){
		clientDao.deleteClient(idClient);
	}
	public Client editClient(Integer idClient){
		return clientDao.editClient(idClient);
	}
	public void updateClient(Client c){
		clientDao.updateClient(c);
	}
	public List<Client> chercherClients(String motCle){
		return clientDao.chercherClients(motCle);
	}
	
	public List<Client> SupprimerClientDontLeNomContient(String motCle){
		for(Client c : clientDao.chercherClients(motCle)){
			clientDao.deleteClient(c.getId());
		}
		return clientDao.listClients();
	}
}
