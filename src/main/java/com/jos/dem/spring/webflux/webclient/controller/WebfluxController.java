package com.jos.dem.spring.webflux.webclient.controller;

import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class WebfluxController {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<String> index(){
    log.info("Calling index");
    return Mono.just("Hello World!");
  }

}
