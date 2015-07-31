package com.bankonet;

import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

public class BankonetAppConfigTest {

	private AnnotationConfigApplicationContext context;

	@Before
	public void SetContext(){
		try{
			context = new AnnotationConfigApplicationContext(BankonetAppConfig.class);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testDataSource() {
		DriverManagerDataSource dataSource = context.getBean(DriverManagerDataSource.class);
		assertEquals("root", dataSource.getUsername());
		assertEquals("", dataSource.getPassword());
		assertEquals("jdbc:mysql:///bankospring", dataSource.getUrl());
	}

	@Test
	public void testEntityManagerFactory(){
		EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		assertNotNull(emf);
	}
	@Test
	public void testPlatformTransactionManager(){
		PlatformTransactionManager transaction = context.getBean(PlatformTransactionManager.class);
		assertNotNull(transaction);
	}

}
