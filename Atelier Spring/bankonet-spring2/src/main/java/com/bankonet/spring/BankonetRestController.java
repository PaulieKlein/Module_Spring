package com.bankonet.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;

@Controller
@RequestMapping(value = "/clients")
public class BankonetRestController {

	@Autowired
	IBankonetMetier metier;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void saveClient(@RequestBody Client c) throws Exception{
		 metier.addClient(c); 
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
    public void supprimer(@RequestParam(value="id")  Integer id) {
		metier.deleteClient(id);
    }
	
	@RequestMapping(value ="/listClients/{motCle}",method = RequestMethod.GET)
	@ResponseBody
	public List<Client> search(@PathVariable("motCle") String motCle){
		return metier.chercherClients(motCle);
	}
	@RequestMapping(value ="/{idClient}/comptes",method = RequestMethod.GET)
	@ResponseBody
	public List<Compte> searchCompte(@PathVariable("idClient") Integer idClient){
		return metier.chercherCompte(idClient);
	}
	
	@RequestMapping(value="/searchLM/{nom}",method = RequestMethod.GET)
	@ResponseBody
	public List<Client> searchClientN_P(@PathVariable("nom") String nom){
		return metier.searchClientLogin_Motdepasse(nom);
	}
	
	@RequestMapping(value="/searchNP/{mot}",method = RequestMethod.GET)
	@ResponseBody
	public List<Client> searchClientM_L(@PathVariable("mot") String mot){
		return metier.searchClientNom_Prenom(mot);
	}


}