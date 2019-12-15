package com.pradeep.springbootactivemqconsumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {

	public Consumer1() {
	System.out.println("Consumer1 created.....");
	}
	
    @JmsListener(destination = "pradeep.queue")
    public void listener(String message) {
        System.out.println("  Consumer 1 <=====> Received Message: " + message);
    }
}
