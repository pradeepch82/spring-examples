package com.pradeep.springbootactivemqsubscriber;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Subsriber3 {

	public Subsriber3() {
	System.out.println("Subscriber3 created....");
	}
	
	
	@JmsListener(destination = "pradeep.topic")
   public void consumeMessage(String message) {
       System.out.println("@@@@@@@ Topic Subriber3 : Received Message:" + message);
   }
}
