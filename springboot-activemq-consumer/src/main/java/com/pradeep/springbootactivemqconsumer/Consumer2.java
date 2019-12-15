package com.pradeep.springbootactivemqconsumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {

	public Consumer2() {
	System.out.println("Consumer2 created.....");
	}
	
    @JmsListener(destination = "pradeep.queue")
    public void listener(String message) {
        System.out.println("  Consumer 2 <##########> Received Message: " + message);
    }
}
