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
        return new Interchange("my-interchange");
    }

    @Bean
    public Sequence sequence(){
        return new Sequence("my-sequence");
    }

    @Bean
    public Chaining chaining(){
        return Chaining.builder()
                .chain(sequence())
                .to(interchange())
                .withPath("my-inter-to-my-seq")
                .build();
    }

    @Bean
    public Interchange testInterchange(){
        return new Interchange("default");
    }
    @Bean
    public Sequence testSequence(){
        return new Sequence("default");
    }
    @Bean
    public Chaining testChaining(){
        return Chaining.builder()
                .chain(testSequence())
                .to(testInterchange())
                .withPath("test-to-test")
                .build();
    }
}
