package com.bankonet.spring;

import java.util.ArrayList;
import java.util.List;

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


@Controller
public class BankonetController {

	@Autowired
	IBankonetMetier metier;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String index(Model model){
		
		final List<Client> listeClients = metier.listClients();
		model.addAttribute("client",new Client());
		model.addAttribute("liste",listeClients);
		model.addAttribute("result","");
		return "clientsview";
	}
	
	@RequestMapping(value="/saveClient",method = RequestMethod.POST)
	public String saveClient(@Valid Client c, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()) {
			model.addAttribute("liste",  metier.listClients());
			return  "clientsview"; 
		}
		
		try {
			if(c.getId()==0){
				metier.addClient(c);
<<<<<<< HEAD
				String result = "Le client "+c.getId()+" a été ajouté.";
				model.addAttribute("result",result);
			}else {
				metier.updateClient(c);
				String result = "Le client "+c.getId() +" a été modifié.";
=======
				String result = "Un client "+c.getId()+" a été ajouté.";
>>>>>>> 5d086f84bad400007d838be9a5056e9c15306f99
				model.addAttribute("result",result);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("client",new Client());
		model.addAttribute("liste",metier.listClients());
		return  "clientsview"; 
	}
	@RequestMapping(value="/editClient/{id}",method = RequestMethod.GET)
	public String getId(@PathVariable("id") Integer id, Model model){
		model.addAttribute("client",metier.editClient(id));
		model.addAttribute("liste",  metier.listClients());
		return  "clientsview";
	}
	
	
	@RequestMapping(value="/deleteClient", method = RequestMethod.GET)
    public String supprimer(@RequestParam(value="id")  Integer id, Model model) {
		metier.deleteClient(id);
		model.addAttribute("client",new Client());
		model.addAttribute("liste",  metier.listClients());
		String result = "Le client id : "+id+" a été supprimé";
		model.addAttribute("result",result);
		return  "clientsview"; 
    }
	
	@RequestMapping(value="/GererCC",method=RequestMethod.GET)
	public String afficherCC(@RequestParam(value="id")Integer id,Model model){
		Client client = metier.editClient(id);
		model.addAttribute("compte",new CompteCourant());
		model.addAttribute("liste",metier.listComptes(client, "CC"));
		//model.addAttribute("liste",client.getCompteCourantList());
		return "comptesCview";
	}
	@RequestMapping(value="/GererCE",method=RequestMethod.GET)
	public String afficherCE(@RequestParam(value="id")  Integer id,Model model){
		Client client = metier.editClient(id);
		model.addAttribute("compte",new CompteEpargne());
		model.addAttribute("liste",metier.listComptes(client, "CE") );
		return "comptesEview";
	}
}
