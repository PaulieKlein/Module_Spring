package com.bankonet.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.dao.IClientDao;
import com.bankonet.model.Client;

@Service("metier")
public class BankonetMetierImpl implements IBankonetMetier {
	
	@Resource(name="clientDao")
	private IClientDao clientDao;
	
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
}
