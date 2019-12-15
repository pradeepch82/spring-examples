package com.pradeep.springbootactivemqconsumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer3 {

	public Consumer3() {
	System.out.println("Consumer3 created.....");
	}
	
    @JmsListener(destination = "pradeep.queue")
    public void listener(String message) {
        System.out.println("  Consumer 3 <@@@@@@@@@> Received Message: " + message);
    }
}
