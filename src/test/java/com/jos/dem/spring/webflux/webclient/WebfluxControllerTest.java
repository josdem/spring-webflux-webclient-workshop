package com.jos.dem.spring.webflux.webclient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WebfluxControllerTest {

  private final WebTestClient webTestClient;

  @Test
  @DisplayName("Should validate message with Hamcrest")
  public void shouldValidateMessageWithHamcrest(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());

    webTestClient
        .get()
        .uri("/")
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody(String.class)
        .isEqualTo("Hello World!");
  }

  @Test
  @DisplayName("Should validate message with Junit Jupiter")
  public void shouldValidatetMessageWithJunitJupiter(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());

    webTestClient
        .get()
        .uri("/")
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody(String.class)
        .value(message -> assertEquals("Hello World!", message));
  }
}
