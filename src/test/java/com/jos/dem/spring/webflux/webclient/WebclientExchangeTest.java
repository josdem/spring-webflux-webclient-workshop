package com.jos.dem.spring.webflux.webclient;

import static org.springframework.http.HttpStatus.OK;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.web.reactive.function.client.ClientResponse;

import com.jos.dem.spring.webflux.webclient.model.Person;
import com.jos.dem.spring.webflux.webclient.service.WebclientService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebclientExchangeTest {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private WebclientService webClientService;

  @Test
  public void shouldValidateClientResponse() throws Exception {
    log.info("Running: Should validate client response at {}", new Date());
    ClientResponse response = webClientService.getPersonAsClientResponse("josdem").block();
    assertEquals(OK, response.statusCode(), "should get OK status");
  }

}
