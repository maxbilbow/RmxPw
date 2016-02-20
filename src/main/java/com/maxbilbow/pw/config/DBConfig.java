package com.maxbilbow.pw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Max on 08/01/2016.
 */
@Configuration
//@EnableTransactionManagement
@EnableJpaRepositories("com.maxbilbow.pw.repository")
public class DBConfig {//implements DatabaseConfig {//}, TransactionManagementConfigurer {


    @Bean
    public AppProperties properties()
    {
        return new AppProperties();
    }

    @Bean
    public DataSource dataSource(AppProperties properties)
    {

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(properties.getDatabaseDriver());
        dataSource.setUrl(properties.getDatabaseUrl());
        dataSource.setUsername(properties.getDatabaseUsername());
        dataSource.setPassword(properties.getDatabasePassword());
//        dataSource.setConnectionProperties(hibernateProperties(properties));

        return dataSource;
    }


    final Properties hibernateProperties(AppProperties properties) {
        final Properties hibernateProperties = new Properties();//TODO change to create-drop or add config options
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", true ? "update" : "create-drop");
        hibernateProperties.setProperty("hibernate.dialect", properties.getDatabaseDialect());
        hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");
        hibernateProperties.setProperty("autoReconnect","true");
        hibernateProperties.setProperty("createDatabaseIfNotExist","true");
        return hibernateProperties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, AppProperties properties) {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(new String[] { "com.maxbilbow.pw.domain" });

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties(properties));

        return em;
    }


    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
//
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
//
//
//    @Bean
//    public PlatformTransactionManager annotationDrivenTransactionManager(EntityManagerFactory entityManagerFactory) {
//        return transactionManager(entityManagerFactory);
//    }





}
