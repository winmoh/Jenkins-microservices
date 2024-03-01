package com.microservices.demo.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GatewayConfig {
    @Bean
    @Primary
    public ServerProperties serverProperties() {
        return new ServerProperties();
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
