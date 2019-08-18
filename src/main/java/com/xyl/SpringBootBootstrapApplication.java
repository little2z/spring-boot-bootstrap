package com.xyl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.xyl.persistence.repo")
@EntityScan("com.xyl.persistence.model")
@SpringBootApplication
public class SpringBootBootstrapApplication {

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SpringBootBootstrapApplication.class, args);
//		displayAllBeans();
	}

	/**
	 * 展示所有 spring 容器中的对象
	 */
	public static void displayAllBeans() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		for(String beanName : allBeanNames) {
			System.out.println(beanName);
		}
	}

}
