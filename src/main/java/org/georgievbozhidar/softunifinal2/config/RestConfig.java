package org.georgievbozhidar.softunifinal2.config;

import org.springframework.boot.autoconfigure.web.client.RestClientBuilderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class RestConfig {
    @Bean
    public RestClient restClient(){
//        return RestClient.create();
        return RestClient.builder().baseUrl("http://localhost:8081/api").build();
    }
}
