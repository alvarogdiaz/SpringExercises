package com.bosonit.restservice;

import com.bosonit.restservice.entities.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestServiceApplication.class, args);
	}

	@Bean
	@Profile("perfil")
	public CommandLineRunner tryProfile() {
		return p -> {
			System.out.println("PERFIL");
			for(String s : p) {
				System.out.println("ARGS: " + s);
			}
		};
	}

	@Bean(name = "bean1")
	public Person bean1() {
		return new Person(0, "Manolo", "Bilbao", 42);
	}

	@Bean(name = "bean2")
	public Person bean2() {
		return new Person(0, "Lola", "Paris", 52);
	}

	@Bean(name = "bean3")
	public Person bean3() {
		return new Person(0, "Ana", "Madrid", 27);
	}

}
