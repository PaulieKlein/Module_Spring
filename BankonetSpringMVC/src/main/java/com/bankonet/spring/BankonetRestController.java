package com.bankonet.spring;

import java.util.List;

import javax.validation.Valid;

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

@Controller
@RequestMapping(value = "/rest")
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
	
}
