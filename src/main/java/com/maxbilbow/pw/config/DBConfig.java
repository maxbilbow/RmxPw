package com.maxbilbow.pw.config;

import com.maxbilbow.pwcommon.config.AbstractDbConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Max on 08/01/2016.
 */

@Configuration
@EnableTransactionManagement
@EntityScan("com.maxbilbow.pw.domain")
@EnableJpaRepositories("com.maxbilbow.pw.domain.dao")
public class DBConfig extends AbstractDbConfig
{
  @Bean
  public AppProperties properties()
  {
    return new AppProperties();
  }

  @Override
  public DataSource dataSource(Environment aEnv)
  {
    try
    {
      HikariDataSource ds = new HikariDataSource();
      ds.setDriverClassName(aEnv.getRequiredProperty("db.driver"));
      ds.setUsername(aEnv.getRequiredProperty("db.username"));
      ds.setPassword(aEnv.getRequiredProperty("db.password"));
      ds.setJdbcUrl(aEnv.getRequiredProperty("db.url"));
      return ds;
    }
    catch (Exception aException)
    {
      throw aException;// new PwExcep(aException);
    }
  }

//  @Override
//  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env)
//  {
//    return super.entityManagerFactory(dataSource, env);
//  }
//
//  @Override
//  public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)
//  {
//    return super.transactionManager(entityManagerFactory);
//  }
}

