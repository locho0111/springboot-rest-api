package com.rick.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping("/helloWorld")
  public String HelloWorld() {
    return "Hello World!";
  }
}
