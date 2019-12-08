package com.jos.dem.spring.webflux.webclient.service.impl;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.ClientResponse;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.jos.dem.spring.webflux.webclient.service.WebClientService;

import com.jos.dem.spring.webflux.webclient.model.Person;

@Service
public class WebClientServiceImpl implements WebClientService {

  @Autowired
  private WebClient webClient;

  public Mono<String> getGreetings(){
    return webClient.get()
      .uri("/")
      .retrieve()
    .bodyToMono(String.class);
  }

  public Mono<HttpHeaders> getHeaders(){
    return webClient.get()
		  .uri("/")
		  .exchange()
		  .map(response -> response.headers().asHttpHeaders());
  }

  public Mono<ClientResponse> getPersonAsClientResponse(String nickname) {
    return webClient.get()
      .uri("/persons/" + nickname)
      .exchange();
  }

}
