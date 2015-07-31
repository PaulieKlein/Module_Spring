package com.bankonet;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages ="com.bankonet.spring")
public class BankonetMVCConfig extends WebMvcConfigurerAdapter {

	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver jspViewResolver(){
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
	}
	
//	@Bean(name="multipartResolver")
//	public CommonsMultipartResolver getMultipartResolver(){
//		return new CommonsMultipartResolver();
//	}
	
	@Bean(name="localeChangeInterceptor")
	public LocaleChangeInterceptor interceptor(){
		LocaleChangeInterceptor inter = new LocaleChangeInterceptor();
		inter.setParamName("lang");
		return inter;
	}
	
	@Bean(name="messageSource")
	public ReloadableResourceBundleMessageSource getMessageSource(){
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
		resource.setBasename("classpath:messages");
		resource.setDefaultEncoding("UTF-8");
		return resource;
	}
	@Bean(name="localeResolver")
	public CookieLocaleResolver localeResolver(){
		CookieLocaleResolver locale = new CookieLocaleResolver();
		locale.setDefaultLocale(new Locale("fr"));
		return locale;
	}
	 
}
