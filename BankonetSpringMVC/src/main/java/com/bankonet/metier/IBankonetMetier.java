package com.bankonet.metier;

import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;

public interface IBankonetMetier {
	public void addClient(Client c) throws Exception;
	public List<Client> listClients();
	public void deleteClient(Integer idClient);
	public Client editClient(Integer idClient);
	public void updateClient(Client c);
	public List<Client> chercherClients(String motCle);
	public List<Client> SupprimerClientDontLeNomContient(String motCle);
	public void addCompte(Compte c);
	public List<Compte> listComptes(Client client,String type);
	public void deleteCompte(int idClompte);
	public Compte editCompte(int idClompte);
	public void updateCompte(Compte c);
	public List<Compte> findAll();
}
