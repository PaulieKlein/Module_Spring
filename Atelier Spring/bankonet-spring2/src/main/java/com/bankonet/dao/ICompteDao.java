package com.bankonet.dao;

import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;

public interface ICompteDao {
	public void addCompteC(CompteCourant c,Integer id);
	public List<Compte> listComptes(Client client,String type);
	public void deleteCompte(int idClompte);
	public Compte editCompte(int idClompte);
	public void updateCompte(Compte c);
	public List<Compte> findAll();
	public void transfertMontant(Compte cptSource, Compte cptDest, float montant);
	public List<Compte> chercherCompte(Integer id);
}
