package com.bankonet.dao;

import java.util.List;







import com.bankonet.model.Client;
import com.bankonet.model.Compte;


public interface IClientDao {
	
public void addClient(Client c) throws Exception;
public List<Client> listClients();
public void deleteClient(Integer idClient);
public Client editClient(Integer idClient);
public void updateClient(Client c);
public List<Client> chercherClients(String motCle);
public List<Client> searchClient(String nom);
public List<Client> searchClientLogin_Password(String mot);

}
