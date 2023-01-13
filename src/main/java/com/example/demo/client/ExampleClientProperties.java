package com.example.demo.client;

import javax.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("client.config")
@Validated
public record ExampleClientProperties(@NotBlank String username, @NotBlank String password, @NotBlank String endpoint) {}
