package com.jos.dem.spring.webflux.webclient;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.jos.dem.spring.webflux.webclient.model.Person;
import com.jos.dem.spring.webflux.webclient.repository.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/persons")
public class PersonController {

  @Autowired
  private PersonRepository personRepository;

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @GetMapping("/")
  public Flux<Person> getAll(){
    log.info("Getting persons");
    return personRepository.findAll();
  }

  @GetMapping("/{nickname}")
  public Mono<Person> getByIdNickname(@PathVariable String nickname){
    log.info("Calling find person by nickname: " + nickname);
    return personRepository.findByNickname(nickname);
  }

}
