package org.microq.demo;

import org.microq.client.annotation.EnableMicroQ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EnableMicroQ

public class DemoMqClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMqClientApplication.class, args);
    }

}
