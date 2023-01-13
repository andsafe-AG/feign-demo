package com.example.demo.client;

import feign.Client;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.cloud.openfeign.support.FeignHttpClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
  @Bean
  public Client client(final HttpClientConnectionManager httpClientConnectionManager,
                       final FeignHttpClientProperties httpClientProperties) {
    final var defaultRequestConfig = RequestConfig
        .custom()
        .setConnectTimeout(httpClientProperties.getConnectionTimeout())
        .setRedirectsEnabled(httpClientProperties.isFollowRedirects())
        .setCookieSpec(CookieSpecs.STANDARD)
        .build();

    final var httpClient = HttpClientBuilder
        .create()
        .setConnectionManager(httpClientConnectionManager)
        .setDefaultRequestConfig(defaultRequestConfig)
        .build();
    return new ApacheHttpClient(httpClient);
  }
}
