package com.jos.dem.spring.webflux.webclient;

import com.jos.dem.spring.webflux.webclient.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Date;
import org.springframework.web.reactive.function.BodyInserters;

import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {

  @Autowired
  private WebTestClient webTestClient;

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Test
  @DisplayName("Should get all of persons")
  void shouldGetAllPersons() {
    log.info("Running: Should get all persons at {}", new Date());

    webTestClient.get().uri("/persons/")
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.APPLICATION_JSON_VALUE)
            .expectBodyList(Person.class)
            .value(persons -> persons.size(), equalTo(5))
            .value(persons -> persons.contains(new Person("josdem","joseluis.delacruz@gmail.com")))
            .value(persons -> persons.contains(new Person("tgrip", "tgrip@email.com")))
            .value(persons -> persons.contains(new Person("edzero", "edzero@email.com")))
            .value(persons -> persons.contains(new Person("siedrix", "siedrix@email.com")))
            .value(persons -> persons.contains(new Person("mkheck", "mkheck@losheckler.com")));
  }

  @Test
  @DisplayName("Should create a person")
  void shouldCreatePerson() {
    log.info("Running: Should create a person at {}", new Date());

    webTestClient.post()
        .uri("/persons/")
        .body(BodyInserters.fromObject(new Person("starbuxman","josh@email.com")))
        .exchange()
        .expectStatus().isOk();
  }

}
