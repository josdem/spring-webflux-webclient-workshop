package com.jos.dem.spring.webflux.webclient.controller;

import com.jos.dem.spring.webflux.webclient.model.Person;
import com.jos.dem.spring.webflux.webclient.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

  private final PersonRepository personRepository;

  @GetMapping("")
  public Flux<Person> getAll(){
    log.info("Calling persons");
    return personRepository.findAll();
  }

  @GetMapping("/{nickname}")
  public Mono<Person> getByIdNickname(@PathVariable String nickname){
    log.info("Calling find person by nickname {}", nickname);
    return personRepository.findByNickname(nickname);
  }

  @PostMapping("")
  public void save(@RequestBody Person person){
    log.info("Calling save person {}", person);
  }

}
