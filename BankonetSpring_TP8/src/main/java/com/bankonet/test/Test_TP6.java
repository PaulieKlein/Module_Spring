package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Adresse;
import com.bankonet.model.Client;

public abstract class Test_TP6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//Appel bean (par défaut singleton)
		IBankonetMetier metier = (IBankonetMetier) context.getBean("metier");
		try{
			metier.addClient(new Client("Honime","Anne","anne","anne",new Adresse(11, "avenue principale", "City")));
		}catch(Exception e){e.printStackTrace();}
		
		System.out.println(metier.listClients());
	}

}
