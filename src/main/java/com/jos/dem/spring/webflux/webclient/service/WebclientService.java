package com.jos.dem.spring.webflux.webclient.service;

import reactor.core.publisher.Mono;
import org.springframework.http.HttpHeaders;

public interface WebclientService {

  Mono<String> getGreetings();
  Mono<HttpHeaders> getHeaders();

}
