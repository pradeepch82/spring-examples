package com.pradeep.springbootactivemqsubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class Config {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;


    
    @Bean
    public Topic topic() {
    	System.out.println("pradeep.topic created...");
        return new ActiveMQTopic("pradeep.topic");
      }

    
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        
    	System.out.println("connectionfactory created....");
    	
    	ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory();
    	
        factory.setBrokerURL(brokerUrl);
             
        return factory;
    }

     
    
    @Bean
    public JmsTemplate jmsTemplate() {
    	System.out.println("JMSTemplate created....");
       JmsTemplate 	jmsTemplate=new JmsTemplate(activeMQConnectionFactory());
       	return jmsTemplate;
    }
       
    
    
    
}
