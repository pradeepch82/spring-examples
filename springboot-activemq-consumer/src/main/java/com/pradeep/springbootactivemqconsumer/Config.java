package com.pradeep.springbootactivemqconsumer;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@Configuration
public class Config {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public Queue queue() {
    	System.out.println("Queue created...");
        return new ActiveMQQueue("pradeep.queue");
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        System.out.println("Connectionfactory created....");
    	ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
        return factory;
    }

}
