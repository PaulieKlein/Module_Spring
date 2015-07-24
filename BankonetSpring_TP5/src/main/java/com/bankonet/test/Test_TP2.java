package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.ReportService;

public class Test_TP2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//Appel bean (par défaut singleton)
		ReportService reportService1 = (ReportService) context.getBean("reportService");
		ReportService reportService2 = (ReportService) context.getBean("reportService");
		reportService1.setAuteur("Pauline1");
		reportService2.setAuteur("Pauline2");
		reportService1.generate();
		reportService2.generate();
		
		//Appel bean de scope prototype
		ReportService reportService3 = (ReportService) context.getBean("reportServiceScope");
		ReportService reportService4 = (ReportService) context.getBean("reportServiceScope");
		reportService3.setAuteur("Pauline1");
		reportService4.setAuteur("Pauline2");
		reportService3.generate();
		reportService4.generate();

				
	}
}
