package com.pradeep.kafka.kafkastreamdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaNumberProducer {

    private long counter = 0;

    public KafkaNumberProducer() {
	System.out.println("KafkaNumber Producer created.....");
    }
    
    @Autowired
    private KafkaTemplate<String, Long> kafkaTemplate;

    
    @GetMapping("/send")
    public String produce() {
    	
    	while(true) {
        System.out.println("Produced :: " + counter);
        this.kafkaTemplate.sendDefault(counter++);
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	}
         
    	
        
    }

}