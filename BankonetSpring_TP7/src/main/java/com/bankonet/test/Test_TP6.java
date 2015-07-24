package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.BankonetMetierImpl;
import com.bankonet.model.Client;
import com.bankonet.model.Adresse;

public abstract class Test_TP6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//Appel bean (par d�faut singleton)
		BankonetMetierImpl metier = (BankonetMetierImpl) context.getBean("metier");
		//metier.addClient(new Client("toto","tata","log2","mdp2",new Adresse(36, "avenue Cyrnos", "Paris")));
		System.out.println(metier.listClients());
	}

}
