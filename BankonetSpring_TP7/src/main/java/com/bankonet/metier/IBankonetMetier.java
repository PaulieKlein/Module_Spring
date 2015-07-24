package com.bankonet.metier;

import java.util.List;

import com.bankonet.model.Client;

public interface IBankonetMetier {
	public void addClient(Client c);
	public List<Client> listClients();
	public void deleteClient(Integer idClient);
	public Client editClient(Integer idClient);
	public void updateClient(Client c);
	public List<Client> chercherClients(String motCle);
	public List<Client> SupprimerClientDontLeNomContient(String motCle);
}
