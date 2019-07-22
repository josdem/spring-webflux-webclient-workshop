package com.jos.dem.spring.webflux.webclient.service.impl;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import com.jos.dem.spring.webflux.webclient.service.WebfluxService;

public class WewbfluxServiceImpl implements WebfluxService {

  @Autowired
  private WebClient webClient;

  public Mono<String> getGreetings(){
    return webClient.get()
      .uri("/")
      .retrieve()
    .bodyToMono(String.class);
  }

  public Mono<String> getHeaders(){
    Mono<HttpHeaders> result = this.webClient.get()
				.uri("/greeting?name=Spring")
				.exchange()
				.map(response -> response.headers().asHttpHeaders());
  }

}
