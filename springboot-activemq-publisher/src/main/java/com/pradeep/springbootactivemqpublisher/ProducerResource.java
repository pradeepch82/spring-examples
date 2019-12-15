package com.pradeep.springbootactivemqpublisher;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

    @Autowired
    JmsTemplate jmsTemplate;


    @Autowired
    Topic topic;

    
    @GetMapping("/{message}")
    public String publish(@PathVariable("message")
                          final String message) {

        jmsTemplate.convertAndSend(topic,message+" @ "+new Date());
        
        return "Published Successfully";
    }
}
