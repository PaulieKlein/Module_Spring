package com.bankonet.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.bankonet.model.Client;
@Repository("clientDao")
@Scope("prototype")
public class ClientDaoImpl implements IClientDao {
	public void addClient(Client c){
		System.out.println("dans ClientDaoImpl.addClient --> client ajout� !");
	}
	public List<Client> listClients(){
		System.out.println("dans ClientDaoImpl.listClients --> liste de clients !");
		return null;
	}
	public void deleteClient(Integer idClient){
		System.out.println("dans ClientDaoImpl.deleteClient --> client supprim� !");
	}
	public Client editClient(Integer idClient){
		System.out.println("dans ClientDaoImpl.editClient --> client �dit� !");
		return null;
	}
	public void updateClient(Client c){
		System.out.println("dans ClientDaoImpl.updateClient --> client modifi� !");
	}
	public List<Client> chercherClients(String motCle){
		System.out.println("dans ClientDaoImpl.listClients --> liste de clients recherch�s !");
		return null;
	}
}
