package com.bankonet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankonet.model.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
	List<Client> findDistinctPeopleByNomOrPrenom(String nom, String prenom);
	List<Client> findDistinctPeopleByLoginOrMotdepasse(String login, String motdepasse);
}
