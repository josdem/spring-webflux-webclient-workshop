package com.jos.dem.spring.webflux.webclient.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

  private String nickname;
  private String email;

}
