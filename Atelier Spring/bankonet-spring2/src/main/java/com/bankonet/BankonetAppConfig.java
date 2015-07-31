package com.bankonet;


import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.bankonet",  
excludeFilters = @ComponentScan.Filter(value = Configuration.class, type = FilterType.ANNOTATION))
@PropertySource("classpath:jdbc.properties")
@EnableJpaRepositories
public class BankonetAppConfig {

	@Value("${jdbc.username}") private String username;
	@Value("${jdbc.password}") private String password;
	@Value("${jdbc.url}") private String url;
	@Value("${jdbc.driverClassName}") private String driver;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource  driverData = new DriverManagerDataSource();
		driverData.setUsername(username);
		driverData.setPassword(password);
		driverData.setUrl(url);
		driverData.setDriverClassName(driver);
		return driverData;
	}
	@Bean
	public EntityManagerFactory entityManagerFactory(){
		
		EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setDatabasePlatform("org.eclipse.persistence.platform.database.MySQLPlatform");
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setPersistenceUnitName("My_PU");
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.bankonet.model");
		factory.setDataSource(dataSource());
	    factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
	    factory.setJpaDialect(new EclipseLinkJpaDialect());
		Map<String,String> jpaProperties = new HashMap<String,String>();
		jpaProperties.put("eclipselink.weaving","static");
		jpaProperties.put("eclipselink.ddl-generation","create-tables");
		factory.setJpaPropertyMap(jpaProperties);
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	
	@Bean
	public EclipseLinkJpaDialect eclipseLinkJpaDialect() {
	   return new EclipseLinkJpaDialect();
	}
	
	@Bean(name="transactionManager")
	public PlatformTransactionManager txManager(){
		 return new DataSourceTransactionManager(dataSource());
//		JpaTransactionManager transaction = new JpaTransactionManager();
//		transaction.setEntityManagerFactory(entityManagerFactory());
//		 return transaction;
	}
}
