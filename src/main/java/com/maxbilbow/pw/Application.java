package com.maxbilbow.pw;

import click.rmx.web.Browser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({
		"classpath:application.properties"
		,"file:///${appRootDir}/config/app.properties"
		,"file:///${appRootDir}/lib/version"
})
public class Application {


	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		System.setProperty("server.port",context.getEnvironment().getProperty("server.port"));
		new Browser().launch();
	}
}
