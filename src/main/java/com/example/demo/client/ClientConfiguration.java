package com.example.demo.client;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

public class ClientConfiguration {

  @Bean
  public BasicAuthRequestInterceptor basicAuthRequestInterceptor(ExampleClientProperties props) {
    return new BasicAuthRequestInterceptor(props.username(), props.password());
  }
}
