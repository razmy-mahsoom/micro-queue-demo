package org.microq.demo.config;

import org.microq.support.auditor.Chaining;
import org.microq.support.auditor.Interchange;
import org.microq.support.auditor.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class MQConfig {

    @Bean
    public Interchange interchange(){
        return new TestInterchange();
    }

    @Bean
    public Sequence sequence(){
        return new TestSequence();
    }

    @Bean
    public Chaining chaining(){
        return Chaining.builder()
                .chain(sequence())
                .to(interchange())
                .withPath("default-to-default")
                .build();
    }
}
