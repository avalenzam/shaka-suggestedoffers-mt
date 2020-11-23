package com.telefonica.somt.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

/**
 * 
 * @Author: Jean Kevin Diaz Fuertes.
 * @Datecreation: 25 ago. 2020 01:49:40
 * @FileName: RTDMConfig.java
 * @AuthorCompany: Telefónica
 * @version: 0.1
 * @Description: Configuración de conexión para la Base de Datos RTDM
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "daasEntityManagerFactory", transactionManagerRef = "daasTransactionManager", basePackages = {
		"com.telefonica.somt.repository.daas" })

public class DAASConfig {

	@Value(value = "${daas.datasource.maximumPoolSize}")
	private Integer poolSize;
	@Value(value = "${daas.datasource.url}")
	private String url;
	@Value(value = "${daas.datasource.username}")
	private String userName;
	@Value(value = "${daas.datasource.password}")
	private String password;
	@Value(value = "${daas.datasource.driverClassName}")
	private String driverClassName;
	@Value(value = "${daas.datasource.minimumIdle}")
	private Integer minimunIdle;

	
	@Bean(name = "daasDataSource")
	public HikariDataSource dataSource() {
		final HikariDataSource hds = new HikariDataSource();
		hds.setMaximumPoolSize(poolSize);
		hds.setJdbcUrl(url);
		hds.setUsername(userName);
		hds.setPassword(password);
		hds.setDriverClassName(driverClassName);
		hds.setMinimumIdle(minimunIdle);
		return hds;
	}
	
	@Bean(name = "daasEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean daasEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("daasDataSource") HikariDataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.telefonica.somt.entity.daas").persistenceUnit("daas").build();
	}

	@Bean(name = "daasTransactionManager")
	public PlatformTransactionManager dassTransactionManager(
			@Qualifier("daasEntityManagerFactory") EntityManagerFactory daasEntityManagerFactory) {
		return new JpaTransactionManager(daasEntityManagerFactory);
	}

}
