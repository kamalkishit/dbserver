package com.humanize.dbserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class App extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

	public static void main(String[] args) {
		try {
			//EmailSenderService emailSender = new EmailSenderService();
			//emailSender.sendEmail();
			App.run(args);
		} catch (Exception e) {
			e.printStackTrace();
		}

		SpringApplication.run(App.class, args);
	}

	public static void run(String... args) throws Exception {

		System.out.println("i m here");
	}
}
