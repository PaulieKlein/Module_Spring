package com.bankonet.metier;

import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.Virement;

public interface IBankonetMetier {
	public void addClient(Client c) throws Exception;
	public List<Client> listClients();
	public void deleteClient(Integer idClient);
	public Client editClient(Integer idClient);
	public void updateClient(Client c);
	public List<Client> chercherClients(String motCle);
	public List<Client> SupprimerClientDontLeNomContient(String motCle);
	public void addCompteC(CompteCourant c,Integer id);
	public List<Compte> listComptes(Client client,String type);
	public void deleteCompte(int idClompte);
	public Compte editCompte(int idClompte);
	public void updateCompte(Compte c);
	public List<Compte> findAll();
	public Virement effectuerVirement(Compte cptSource, Compte cptDest, float montant);
	public List<Compte> chercherCompte(Integer id);
	public List<Client> searchClientLogin_Motdepasse(String mot);
	public List<Client> searchClientNom_Prenom(String mot);
}
