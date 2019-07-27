package com.jos.dem.spring.webflux.webclient;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import com.jos.dem.spring.webflux.webclient.model.Person;
import com.jos.dem.spring.webflux.webclient.repository.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DemoApplication {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  WebClient webClient() {
    return WebClient.create("http://localhost:8080");
  }

  @Bean
  CommandLineRunner start(PersonRepository personRepository){
    return args -> {

      Arrays.asList(
          new Person("josdem", "joseluis.delacruz@gmail.com"),
          new Person("tgrip", "tgrip@email.com"),
          new Person("edzero", "edzero@email.com"),
          new Person("siedrix", "siedrix@email.com"),
          new Person("mkheck", "mkheck@losheckler.com"))
        .forEach(person -> personRepository.save(person));

    };
  }

}
