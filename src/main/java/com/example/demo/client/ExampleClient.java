package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "example", url = "${client.config.endpoint}", configuration = ClientConfiguration.class)
public interface ExampleClient {

  @GetMapping("/{fact}")
  String getFact(@PathVariable String fact);
}
