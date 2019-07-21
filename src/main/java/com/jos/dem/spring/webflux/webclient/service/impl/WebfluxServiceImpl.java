package com.jos.dem.spring.webflux.webclient.service.impl;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;

public class WewbfluxServiceImpl implements WebfluxService {

  @Autowired
  private WebClient webClient;

  public Mono<String> getGrettings(){
    return webClient.get()
      .uri("/")
      .retrieve()
    .bodyToMono(String.class);
  }

}
