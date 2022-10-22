package org.microq.demo.controller;

import org.microq.client.auditor.template.MQTemplate;
import org.microq.demo.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private MQTemplate mqTemplate;

    @GetMapping("/send")
    public void sendMessage(){
        Person p = new Person("RAZMY",36,"SRI LANKAN");
        mqTemplate.convertAndSend("inter","path",p);
    }
}
