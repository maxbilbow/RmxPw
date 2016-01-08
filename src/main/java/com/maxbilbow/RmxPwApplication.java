package com.maxbilbow;

import click.rmx.web.Browser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@EnableAutoConfiguration
public class RmxPwApplication {


	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(RmxPwApplication.class, args);
		System.setProperty("server.port",context.getEnvironment().getProperty("server.port"));
		new Browser().launch();
	}
}
