package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.IBankonetMetier;

public abstract class Test_TP6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//Appel bean (par défaut singleton)
		IBankonetMetier metier = (IBankonetMetier) context.getBean("metier");
		//metier.addClient(new Client("toto","tata","log2","mdp2",new Adresse(36, "avenue Cyrnos", "Paris")));
		System.out.println(metier.listClients());
	}

}
