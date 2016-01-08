package com.maxbilbow.config;

import click.rmx.persistance.DatabaseConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Max on 08/01/2016.
 */
@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories("com.maxbilbow.repository")
public class DBConfig implements DatabaseConfig {//}, TransactionManagementConfigurer {


    @Bean
    public DataSource dataSource()
    {
        return create();
    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource);
//        em.setPackagesToScan(new String[] { "com.maxbilbow.model" });
//
//        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(additionalProperties());
//
//        return em;
//    }

    final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();//TODO change to create-drop or add config options
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", false ? "update" : "create-drop");
        hibernateProperties.setProperty("hibernate.dialect", getDialect());
        hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");
        hibernateProperties.setProperty("autoReconnect","true");
        hibernateProperties.setProperty("createDatabaseIfNotExist","true");
        return hibernateProperties;
    }

//    @Bean
//    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
//        final JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//    @Autowired
//    private EntityManagerFactory entityManagerFactory;
//
//    @Override
////    @Bean
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return transactionManager(entityManagerFactory);
//    }

    @Override
    public String getUrl()
    {
        return "jdbc:h2:"+System.getProperty("h2location")+"/app";
    }

    @Override
    public String getDriver()
    {
        return "org.h2.Driver";
    }

    @Override
    public String getUsername()
    {
        return "";
    }

    @Override
    public String getPassword()
    {
        return "";
    }

    @Override
    public String getDialect()
    {
        return "org.hibernate.dialect.H2Dialect";
    }


}
