package com.xyl;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@EnableJpaRepositories("com.xyl.persistence.repo")
//@EntityScan("com.xyl.persistence.model")
//@SpringBootApplication
public class CustomerExitApplication implements ExitCodeGenerator {

	public static void main(String[] args) {

		SpringApplication.run(CustomerExitApplication.class, args);
//		System.exit(SpringApplication.exit(SpringApplication.run(CustomerExitApplication.class, args)));

	}

	@Override
	public int getExitCode() {
		System.out.println("return cutomer exit code 110");
		return 110;
	}


}
