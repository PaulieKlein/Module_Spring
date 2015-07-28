package com.bankonet.dao;

import java.util.List;



import com.bankonet.model.Client;


public interface IClientDao {
	
public void addClient(Client c) throws Exception;
public List<Client> listClients();
public void deleteClient(Integer idClient);
public Client editClient(Integer idClient);
public void updateClient(Client c);
public List<Client> chercherClients(String motCle);

}
