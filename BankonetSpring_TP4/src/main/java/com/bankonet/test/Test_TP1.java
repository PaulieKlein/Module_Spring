package com.bankonet.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.*;

public class Test_TP1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ReportService reportService = (ReportService) context.getBean("reportService");
		reportService.generate();
	}

}
