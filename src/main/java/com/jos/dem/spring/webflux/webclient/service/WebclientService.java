package com.jos.dem.spring.webflux.webclient.service;

public interface WebfluxService {

  Mono<String> getGrettings();
  Mono<HttpHeaders> getHeaders();

}
