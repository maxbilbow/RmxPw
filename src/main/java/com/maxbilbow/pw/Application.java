package com.maxbilbow.pw;

import click.rmx.web.Browser;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.WebApplicationInitializer;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.jar.Manifest;

@SpringBootApplication
@EnableAutoConfiguration
public class Application implements WebApplicationInitializer
{
  @Resource
  Environment mEnvironment;

  @Resource
  ApplicationContext mContext;

  Logger mLogger = Logger.getLogger(Application.class);
  public static void main(String[] args)
  {
    try
    {
      ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    }
    catch (Exception e)
    {
      Logger.getLogger(Application.class).fatal(e);
    }
  }

  @Override
  public void onStartup(ServletContext aServletContext) throws ServletException
  {
    try
    {
      System.setProperty("server.port", mEnvironment.getProperty("server.port"));
      new Browser().launch();
    }
    catch (Exception e)
    {
      mLogger.error(e);
    }
  }

  private String getApplicationVersion()
  {
    String version = "N/A";
    try
    {
      org.springframework.core.io.Resource manifestResource = mContext.getResource("/META-INF/MANIFEST.MF");
      if (manifestResource != null)
      {
        Manifest manifest = new Manifest(manifestResource.getInputStream());
        String value = manifest.getMainAttributes().getValue("Implementation-Version");
        if (value != null)
        {
          version = value;
        }
      }
      return version;
    }
    catch (IOException e)
    {
      mLogger.error(e);//new FrontendException(e);
    }
    return "N/A";
  }

  //application wide Gson instance
  @Bean
  public Gson Gson()
  {
    return new Gson();
  }
}
