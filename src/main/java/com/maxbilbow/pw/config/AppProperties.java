package com.maxbilbow.pw.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Max on 19/01/2016.
 */
@ConfigurationProperties(prefix = "politicsWeekly", ignoreInvalidFields = true)
public class AppProperties {

    private String databaseDriver;
    private String databaseUrl;
    private String databaseUsername;
    private String databasePassword;

    private String databaseDialect;

    public String getDatabasePassword()
    {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword)
    {
        this.databasePassword = databasePassword;
    }

    public String getDatabaseUsername()
    {
        return databaseUsername;
    }

    public void setDatabaseUsername(String databaseUsername)
    {
        this.databaseUsername = databaseUsername;
    }

    public String getDatabaseUrl()
    {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl)
    {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabaseDriver()
    {
        return databaseDriver;
    }

    public void setDatabaseDriver(String databaseDriver)
    {
        this.databaseDriver = databaseDriver;
    }

    public String getDatabaseDialect()
    {
        return databaseDialect;
    }

    public void setDatabaseDialect(String databaseDialect)
    {
        this.databaseDialect = databaseDialect;
    }
}
