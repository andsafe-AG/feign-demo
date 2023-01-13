package com.example.demo.controller;

import com.example.demo.client.ExampleClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

  private final ExampleClient client;

  public ExampleController(ExampleClient client) {this.client = client;}

  @GetMapping("/")
  public String getCatFact() {
    return client.getFact("fact");
  }
}
