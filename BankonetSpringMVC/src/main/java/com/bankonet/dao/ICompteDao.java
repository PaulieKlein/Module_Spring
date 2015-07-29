package com.bankonet.dao;

import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;

public interface ICompteDao {
	public void addCompte(Compte c);
	public List<Compte> listComptes(Client client,String type);
	public void deleteCompte(int idClompte);
	public Compte editCompte(int idClompte);
	public void updateCompte(Compte c);
	public List<Compte> findAll();
}
