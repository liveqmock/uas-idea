package uas;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Boot IOC
 * 
 * @author percy
 *
 */
// @Configuration
// @EnableJpaRepositories("uas.repo")
// @EnableTransactionManagement
// @EnableJpaAuditing
// @ComponentScan(basePackages = "uas", useDefaultFilters = false,
// excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value
// = { Controller.class }) })
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "uas")
@ComponentScan(basePackages = "uas")
@PropertySource("classpath:resources.properties")
public class AppConfig {

	@Autowired
	private Environment env;

//	@Bean
//	public DataSource dataSource() throws PropertyVetoException {
//		// System.out.println("=======================env:" +
//		// env.getProperty("jdbc.driverClass"));
//		// String driverClass = env.getProperty("jdbc.driverClass");
//		// String jdbcUrl = env.getProperty("jdbc.url");
//		// String user = env.getProperty("jdbc.username");
//		// String password = env.getProperty("jdbc.password");
//
//		String driverClass = "com.mysql.jdbc.Driver";
//		String jdbcUrl = "jdbc:mysql://192.168.20.79:3306/uas";
//		String user = "root";
//		String password = "123456";
//
//		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//		comboPooledDataSource.setDriverClass(driverClass);
//		comboPooledDataSource.setJdbcUrl(jdbcUrl);
//		comboPooledDataSource.setUser(user);
//		comboPooledDataSource.setPassword(password);
//
//		return comboPooledDataSource;
//	}
//
//	@Bean
//	public EntityManagerFactory entityManagerFactory1()
//			throws PropertyVetoException {
//
//		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//		entityManagerFactory.setDataSource(dataSource());
//
//		// <property name="persistenceXmlLocation"
//		// value="classpath:/persistence.xml"/>
//		entityManagerFactory
//				.setPersistenceXmlLocation("/home/percy/persistence.xml");
//		entityManagerFactory
//				.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//		Properties jpaProperties = new Properties();
//
//		DefaultPersistenceUnitManager pum = new DefaultPersistenceUnitManager();
//		pum.setPersistenceXmlLocation("/home/percy/persistence.xml");
//		// pum.setDefaultDataSource(dataSource());
//
//		// entityManagerFactory.setPersistenceUnitManager(pum);
//		entityManagerFactory.setPersistenceUnitName("defaultPU");
//
//		jpaProperties.setProperty("hibernate.dialect",
//				"org.hibernate.dialect.MySQL5InnoDBDialect");
//		jpaProperties.setProperty("hibernate.show_sql", "true");
//		jpaProperties.setProperty("hibernate.format_sql", "true");
//		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
//		// jpaProperties.setProperty("hibernate.dialect",
//		// env.getProperty("hibernate.dialect"));
//		// jpaProperties.setProperty("hibernate.show_sql",
//		// env.getProperty("hibernate.show_sql"));
//		// jpaProperties.setProperty("hibernate.format_sql",
//		// env.getProperty("hibernate.format_sql"));
//		// jpaProperties.setProperty("hibernate.hbm2ddl.auto",
//		// env.getProperty("hibernate.hbm2ddl.auto"));
//
//		entityManagerFactory.setJpaProperties(jpaProperties);
//		return entityManagerFactory.getObject();
//	}
//
//	@Bean
//	@Autowired
//	public PlatformTransactionManager transactionManager1()
//			throws PropertyVetoException {
//		JpaTransactionManager txManager = new JpaTransactionManager();
//		txManager.setEntityManagerFactory(entityManagerFactory1());
//		return txManager;
//	}

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
		// File file = new File("");
		// Thread.currentThread().getContextClassLoader().getResource("");
		Resource resource = new ClassPathResource("file:E:/temp/resources.properties");

		return new JpaTransactionManager();
	}

	@Bean
	@Lazy(value = false)
	public Properties properties() {
		System.out.println("====================="
				+ env.getProperty("jdbc.driverClass"));
		Properties properties = new Properties();
		properties.put("hibernate.connection.driver_class",
				"com.mysql.jdbc.Driver");
		properties.put("hibernate.connection.url",
				"jdbc:mysql://localhost:3306/uas");
		properties.put("hibernate.connection.username", "root");
		properties.put("hibernate.connection.password", "123456");
		properties.put("hibernate.c3p0.min_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "true");
		properties.put("hibernate.dialect",
				"org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
}
