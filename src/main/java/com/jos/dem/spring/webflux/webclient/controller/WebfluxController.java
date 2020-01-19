package com.jos.dem.spring.webflux.webclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class WebfluxController {

  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<String> index(){
    log.info("Calling index");
    return Mono.just("Hello World!");
  }

}
