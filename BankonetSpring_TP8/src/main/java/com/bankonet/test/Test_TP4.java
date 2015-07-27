package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.model.Client;

public abstract class Test_TP4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//Appel bean (par défaut singleton)
		Client client = (Client) context.getBean("client");
		System.out.println(client.toString());
	}

}
