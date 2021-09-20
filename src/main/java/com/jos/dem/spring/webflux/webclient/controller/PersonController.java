package com.jos.dem.spring.webflux.webclient.controller;

import com.jos.dem.spring.webflux.webclient.model.Person;
import com.jos.dem.spring.webflux.webclient.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

  private final PersonRepository personRepository;

  @GetMapping("")
  public Flux<Person> getAll() {
    log.info("Calling persons");
    return personRepository.findAll();
  }

  @GetMapping("/{nickname}")
  public Mono<Person> getByIdNickname(@PathVariable String nickname) {
    log.info("Calling find person by nickname {}", nickname);
    return personRepository.findByNickname(nickname);
  }

  @PostMapping("")
  public void save(@RequestBody Person person) {
    log.info("Calling save person {}", person);
    personRepository.save(person);
  }

  @PutMapping("/{nickname}")
  public void update(@RequestBody Person person, @PathVariable String nickname) {
    log.info("Calling update person {}", person);
    personRepository.findByNickname(nickname).subscribe(saved -> {
      saved.setNickname(person.getNickname());
      saved.setEmail(person.getEmail());
    });
  }
}
