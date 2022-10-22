package org.microq.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.microq.client.auditor.template.MQTemplate;
import org.microq.client.auditor.template.SimpleMQTemplate;
import org.microq.support.auditor.Chaining;
import org.microq.support.auditor.Interchange;
import org.microq.support.auditor.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.Socket;

@Configuration
public class MQConfig {

    @Autowired
    private Socket socket;

    private ObjectMapper mapper;
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
    public MQTemplate mqTemplate(Socket socket,ObjectMapper mapper){
        SimpleMQTemplate simpleMQTemplate = new SimpleMQTemplate(socket,mapper);
        return simpleMQTemplate;
    }



}
