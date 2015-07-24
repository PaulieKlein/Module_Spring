package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.BankonetMetier;

public abstract class Test_TP5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//Appel bean (par d�faut singleton)
		BankonetMetier metier = (BankonetMetier) context.getBean("metier");
		metier.listClients();
	}

}
