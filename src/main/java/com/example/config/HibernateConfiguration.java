package com.example.config;

import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.bean.Test;

@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
@PropertySource(value = { "classpath:application.properties" })
@ComponentScans(value = { @ComponentScan("com.example.dao"), @ComponentScan("com.example.service") })
public class HibernateConfiguration {
	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		Properties props = new Properties();

		// Setting JDBC properties
		// props.put(DRIVER, env.getProperty("jdbc.driverClassName"));
		// props.put(URL, env.getProperty("jdbc.url"));
		// props.put(USER, env.getProperty("jdbc.username"));
		// props.put(PASS, env.getProperty("jdbc.password"));

		// Setting Hibernate properties
		props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
		props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));

//		 Setting C3P0 properties
//		 props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
//		 props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
//		 props.put(C3P0_ACQUIRE_INCREMENT,
//		 env.getProperty("hibernate.c3p0.acquire_increment"));
//		 props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
//		 props.put(C3P0_MAX_STATEMENTS,
//		 env.getProperty("hibernate.c3p0.max_statements"));

		factoryBean.setHibernateProperties(props);
		factoryBean.setAnnotatedClasses(Test.class);
		factoryBean.setDataSource(getDataSource());

		return factoryBean;
	}

	@Bean
	public PlatformTransactionManager getTransactionManager() {
		// HibernateTransactionManager transactionManager = new
		// HibernateTransactionManager();
		// transactionManager.setSessionFactory(getSessionFactory().getObject());
		// return transactionManager;

		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(getSessionFactory().getObject());
		// transactionManager.setDataSource(getDataSource());
		// transactionManager.setJpaDialect(jpaDialect());
		return transactionManager;

	}
	//
	// @Bean
	// public LocalSessionFactoryBean getSessionFactory() {
	// LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	// sessionFactory.setDataSource(getDataSource());
	// sessionFactory.setPackagesToScan(new String[] { "com.example.bean" });
	// sessionFactory.setHibernateProperties(hibernateProperties());
	// sessionFactory.setAnnotatedClasses(Test.class);
	// return sessionFactory;
	// }

	// @Bean
	// public DataSource dataSource() {
	// DriverManagerDataSource dataSource = new DriverManagerDataSource();
	// dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
	// dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
	// dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
	// dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
	// return dataSource;
	// }

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
		dataSource.setUsername("test");
		dataSource.setPassword("1qaz2wsx@");

		return dataSource;
	}

	// private Properties hibernateProperties() {
	// Properties properties = new Properties();
	// properties.put("hibernate.dialect",
	// environment.getRequiredProperty("hibernate.dialect"));
	// properties.put("hibernate.show_sql",
	// environment.getRequiredProperty("hibernate.show_sql"));
	// properties.put("hibernate.format_sql",
	// environment.getRequiredProperty("hibernate.format_sql"));
	// return properties;
	// }

	// @Bean
	// public HibernateTransactionManager transactionManager() {
	// HibernateTransactionManager txManager = new HibernateTransactionManager();
	// txManager.setSessionFactory(getSessionFactory().getObject());
	// return txManager;
	// }

	// @Bean
	// public PlatformTransactionManager transactionManager(final
	// EntityManagerFactory emf) {
	// final JpaTransactionManager transactionManager = new JpaTransactionManager();
	// transactionManager.setEntityManagerFactory(getSessionFactory().getObject());
	// transactionManager.setDataSource(getDataSource());
	// // transactionManager.setJpaDialect(jpaDialect());
	// return transactionManager;
	// }

	// @Bean
	// public PlatformTransactionManager hibernateTransactionManager() {
	// HibernateTransactionManager transactionManager = new
	// HibernateTransactionManager();
	// transactionManager.setSessionFactory(getSessionFactory().getObject());
	// return transactionManager;
	// }

	// @Bean
	// public JpaTransactionManager transactionManager() {
	// JpaTransactionManager transactionManager = new JpaTransactionManager();
	// transactionManager.setBeanFactory((BeanFactory)
	// sessionFactory().getObject());
	// return transactionManager;
	// }
}
