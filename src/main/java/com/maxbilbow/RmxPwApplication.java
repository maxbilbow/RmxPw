package com.maxbilbow;

import click.rmx.web.Browser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class RmxPwApplication {


	public static void main(String[] args) {

		SpringApplication.run(RmxPwApplication.class, args);
		new Browser().launch();
	}
}
