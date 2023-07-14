package com.dev.lib.services;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@ConditionalOnProperty(value = "com.dev.lib.services.config.enabled", havingValue = "true", matchIfMissing = true)
public class ExampleConfiguration {
    // Create your Bean definitions here
    @Bean
    public MyBean myBean() {
        return new MyBean("hello");
    }

}
