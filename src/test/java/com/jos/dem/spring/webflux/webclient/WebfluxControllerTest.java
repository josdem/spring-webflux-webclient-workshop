package com.jos.dem.spring.webflux.webclient;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebfluxControllerTest {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private WebTestClient webTestClient;

  @Test
  @DisplayName("Should validate message with Hamcrest")
  public void shouldValidateMessageWithHamcrest() throws Exception {
    log.info("Running: Should validate message with Hamcrest at {}", new Date());

    webTestClient.get().uri("/")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class).isEqualTo("Hello World!");
  }

  @Test
  @DisplayName("Should validate message with Junit Jupiter")
  public void shouldValidatetMessageWithJunitJupiter() throws Exception {
    log.info("Running: Should validate message with Junit Jupiter at {}", new Date());

    webTestClient.get().uri("/")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class)
            .value(message -> assertEquals("Hello World!", message));
  }

}