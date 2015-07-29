package com.bankonet.spring;

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
@RequestMapping(value = "/comptes")
public class BankonetComptesController {

	@Autowired
	IBankonetMetier metier;
	
//	@RequestMapping(value="/editCompte/{id}",method = RequestMethod.GET)
//	public String getId(@PathVariable("id") Integer id, Model model){
//		model.addAttribute("compte",metier.editCompte(id));
//		//model.addAttribute("liste",  metier.listComptes());
//		return  "comptesCview";
//	}
//	
//	
//	@RequestMapping(value="/deleteClient", method = RequestMethod.GET)
//    public String supprimer(@RequestParam(value="id")  Integer id, Model model) {
//		metier.deleteClient(id);
//		model.addAttribute("compte",new CompteCourant());
//		//model.addAttribute("liste",  metier.listClients());
//		String result = "Le compte id : "+id+" a été supprimé";
//		model.addAttribute("result",result);
//		return  "comptesCview"; 
//    }
	
}
