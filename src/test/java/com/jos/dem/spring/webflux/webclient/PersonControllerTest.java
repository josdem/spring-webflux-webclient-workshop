package com.jos.dem.spring.webflux.webclient;

import com.jos.dem.spring.webflux.webclient.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.hamcrest.Matchers.equalTo;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class PersonControllerTest {

  private final WebTestClient webTestClient;

  @Test
  @DisplayName("Should get all of persons")
  void shouldGetAllPersons(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());

    webTestClient
        .get()
        .uri("/persons/")
        .exchange()
        .expectStatus()
        .isOk()
        .expectHeader()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .expectBodyList(Person.class)
        .value(persons -> persons.size(), equalTo(5))
        .value(persons -> persons.contains(new Person("josdem", "joseluis.delacruz@gmail.com")))
        .value(persons -> persons.contains(new Person("tgrip", "tgrip@email.com")))
        .value(persons -> persons.contains(new Person("edzero", "edzero@email.com")))
        .value(persons -> persons.contains(new Person("siedrix", "siedrix@email.com")))
        .value(persons -> persons.contains(new Person("mkheck", "mkheck@losheckler.com")));
  }

  @Test
  @DisplayName("Should create a person")
  void shouldCreatePerson(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());

    webTestClient
        .post()
        .uri("/persons/")
        .body(BodyInserters.fromValue(new Person("starbuxman", "josh@email.com")))
        .exchange()
        .expectStatus()
        .isOk();
  }

  @Test
  @DisplayName("Should update a person")
  void shouldUpdatePerson(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());

    webTestClient
            .put()
            .uri("/persons/tgrip")
            .body(BodyInserters.fromValue(new Person("tgip", "tgrip@gmail.com")))
            .exchange()
            .expectStatus()
            .isOk();

    webTestClient
            .get()
            .uri("/persons/tgrip")
            .exchange()
            .expectBody().jsonPath("email", "tgrip@gmail.com");
  }
}
