package br.com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages="br.com.test")
@EnableJpaRepositories
@EnableTransactionManagement
@EntityScan(basePackages={ "br.com.test.employeedomain", "br.com.test.vo" })
@EnableZuulProxy
public class StaffServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffServerApplication.class, args);
	}

}