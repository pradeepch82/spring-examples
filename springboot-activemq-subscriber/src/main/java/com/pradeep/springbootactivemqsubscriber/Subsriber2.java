package com.pradeep.springbootactivemqsubscriber;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Subsriber2 {

	public Subsriber2() {
	System.out.println("Subscriber2 created....");
	}
	
	
	@JmsListener(destination = "pradeep.topic")
   public void consumeMessage(String message) {
       System.out.println("######## Topic Subriber2 : Received Message:" + message);
   }
}
