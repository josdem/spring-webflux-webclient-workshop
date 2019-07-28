package com.jos.dem.spring.webflux.webclient;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.jos.dem.spring.webflux.webclient.model.Person;
import com.jos.dem.spring.webflux.webclient.service.WebclientService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebfluxControllerTest {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private WebclientService webclientService;

  @Test
  public void shouldGetHelloWorld() throws Exception {
    log.info("Running: Should get hello world message at {}", new Date());
    String response = webclientService.getGreetings().block();
    assertEquals("Hello World!", response);
  }

  @Test
  public void shouldGetHeaders() throws Exception {
    log.info("Running: Should get headers at {}", new Date());
    HttpHeaders headers = webclientService.getHeaders().block();
    assertEquals("text/plain;charset=UTF-8", headers.getContentType().toString());
    assertEquals(12L, headers.getContentLength());
  }

}
