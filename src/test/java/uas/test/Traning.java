package uas.test;

import java.util.Properties;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.PlatformTransactionManager;

import uas.service.AuthzService;

@ContextConfiguration(classes = Traning.class)
@EnableJpaRepositories(basePackages = "uas")
@ComponentScan(basePackages = "uas", useDefaultFilters = false, excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = { Controller.class }) })
public class Traning {
	// @Autowired
	// private WebApplicationContext wac;
	 @Autowired
	 AuthzService authzService;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setPackagesToScan("uas");
		localContainerEntityManagerFactoryBean
				.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		localContainerEntityManagerFactoryBean.setJpaProperties(properties());
		return localContainerEntityManagerFactoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

	@Bean
	public Properties properties() {
		Properties properties = new Properties();
		properties.put("hibernate.connection.driver_class",
				"com.mysql.jdbc.Driver");
		properties.put("hibernate.connection.url",
				"jdbc:mysql://192.168.20.79:3306/uas");
		properties.put("hibernate.connection.username", "root");
		properties.put("hibernate.connection.password", "123456");
		properties.put("hibernate.c3p0.min_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "true");
		properties.put("hibernate.dialect",
				"org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	
	
	@Test
	public void test() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(Traning.class);
		ctx.refresh();

//		Map<String, Object> beans = ctx
//				.getBeansWithAnnotation(org.springframework.stereotype.Service.class);
//		 AuthzService authz = ctx.getBean("authzService", AuthzService.class);
		System.out.println("=========================" + authzService);
	}

}
