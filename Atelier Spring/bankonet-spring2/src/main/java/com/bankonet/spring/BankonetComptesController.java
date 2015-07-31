package com.bankonet.spring;

import java.util.Iterator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;
import com.bankonet.model.Virement;

@Controller
public class BankonetComptesController {

	@Autowired
	IBankonetMetier metier;
	
	@RequestMapping(value="/editCompteCC/{id}",method = RequestMethod.GET)
	public String getIdCC(@RequestParam(value="idClient")Integer idClient,@PathVariable("id") Integer id, Model model){
		Client client = metier.editClient(idClient);
		model.addAttribute("compte",metier.editCompte(id));
		model.addAttribute("liste",client.getCompteCourantList());
		model.addAttribute("client",client);
		return  "comptesCview";
	}
	
	@RequestMapping(value="/editCompteCE/{id}",method = RequestMethod.GET)
	public String getIdCE(@RequestParam(value="idClient")Integer idClient,@PathVariable("id") Integer id, Model model){
		Client client = metier.editClient(idClient);
		model.addAttribute("compte",metier.editCompte(id));
		model.addAttribute("liste",client.getCompteEpargneList());
		model.addAttribute("client",client);
		return  "comptesEview";
	}
	
	@RequestMapping(value="/{idClient}/saveCompteC",method = RequestMethod.POST)
	public String saveCompteC(@PathVariable("idClient")Integer idClient,@Valid CompteCourant c, BindingResult bindingResult,Model model){
		
		Client client = metier.editClient(idClient);
		
		if(bindingResult.hasErrors()) {
			
			model.addAttribute("liste",client.getCompteCourantList());
			return  "comptesCview"; 
		}

			if(c.getIdentifiant()==0){
				client.ajouterCompteCourant(c);
				metier.updateClient(client);
				client = metier.editClient(idClient);
				String result = "Un compte a été ajouté.";
				model.addAttribute("result",result);
			}else {
				c.setClient(client);
				client.modifierCompteCourant(c);
				metier.updateClient(client);
				client = metier.editClient(idClient);
				String result = "Le compte "+c.getIdentifiant()+" à été mis à jour";
				model.addAttribute("result",result);
			}
		
		model.addAttribute("compte",new CompteCourant());
		model.addAttribute("client",client);
		model.addAttribute("liste",client.getCompteCourantList());
		return  "comptesCview";  
	}
	
	@RequestMapping(value="/{idClient}/saveCompteE",method = RequestMethod.POST)
	public String saveCompteE(@PathVariable("idClient")Integer idClient,@Valid CompteEpargne c, BindingResult bindingResult,Model model){
		
		Client client = metier.editClient(idClient);
		
		if(bindingResult.hasErrors()) {
			
			model.addAttribute("liste",client.getCompteEpargneList());
			return  "comptesEview"; 
		}

		
		if(c.getIdentifiant()==0){
			client.ajouterCompteEpargne(c);
			metier.updateClient(client);
			client = metier.editClient(idClient);
			String result = "Le compte "+c.getIdentifiant()+" a été ajouté.";
			model.addAttribute("result",result);
		}else {
			c.setClient(client);
			client.modifierCompteEpargne(c);
			metier.updateClient(client);
			String result = "Le compte "+c.getIdentifiant()+" à été mis à jour";
			model.addAttribute("result",result);
		}
		
		model.addAttribute("compte",new CompteEpargne());
		model.addAttribute("client",client);
		model.addAttribute("liste",client.getCompteEpargneList());
		return  "comptesEview";  
	}
	
	@RequestMapping(value="/deleteCompteC", method = RequestMethod.GET)
    public String supprimerC(@RequestParam(value="id")  Integer id,@RequestParam(value="idClient")  Integer idClient, Model model) {
//		metier.deleteCompte(id);
//		Client client = metier.editClient(idClient);
		
//		Compte cc = metier.editCompte(id);
		Client client = metier.editClient(idClient);
		Iterator it = client.getCompteCourantList().iterator();
		while(it.hasNext()){
			CompteCourant item = (CompteCourant) it.next();
			if(item.getIdentifiant() == id){
				it.remove();
			}
		}
		
		metier.updateClient(client);
		model.addAttribute("liste",client.getCompteCourantList());
		model.addAttribute("client",client);
		model.addAttribute("compte",new CompteCourant());
		String result = "Le compte id : "+id+" a été supprimé";
		model.addAttribute("result",result);
		

		
		return  "comptesCview";
		
    }
	
	@RequestMapping(value="/deleteCompteE", method = RequestMethod.GET)
    public String supprimerE(@RequestParam(value="id")  Integer id,@RequestParam(value="idClient")  Integer idClient, Model model) {
//		metier.deleteCompte(id);
//		Client client = metier.editClient(idClient);
		
//		Compte cc = metier.editCompte(id);
		Client client = metier.editClient(idClient);
		Iterator it = client.getCompteEpargneList().iterator();
		while(it.hasNext()){
			CompteEpargne item = (CompteEpargne) it.next();
			if(item.getIdentifiant() == id){
				it.remove();
			}
		}
		metier.updateClient(client);
		model.addAttribute("liste",client.getCompteEpargneList());
		model.addAttribute("client",client);
		model.addAttribute("compte",new CompteEpargne());
		String result = "Le compte id : "+id+" a été supprimé";
		model.addAttribute("result",result);
		return  "comptesEview"; 
    }
	
	@RequestMapping(value="/{id}/virement", method = RequestMethod.GET)
	public String afficherVirement(@PathVariable("id")Integer idClient, Model model){
		Client client = metier.editClient(idClient);
		model.addAttribute("client", client);
		model.addAttribute("liste", client.getComptes());
		return "virement";
	}
	@RequestMapping(value="/{id}/traiterVirement", method = RequestMethod.POST)
	public String effectuerVirement(@PathVariable("id")Integer idClient,@RequestParam(value="compteSource")  Integer idSr,@RequestParam(value="compteDestination")  Integer idDest,@RequestParam(value="montant")  float montant,@Valid Virement v, BindingResult bindingResult,Model model){
		Client client = metier.editClient(idClient);
		Compte cptSource = client.getCompte(idSr);
		Compte cptDest = client.getCompte(idDest);

		metier.effectuerVirement(cptSource, cptDest, montant);
		model.addAttribute("compteSource", cptSource);
		model.addAttribute("compteDestination", cptDest);
		return "virementEffectuer";

	}
}
