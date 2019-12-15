package com.pradeep.springbootactivemqsubscriber;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Subsriber1 {

	
	public Subsriber1() {
	System.out.println("Subscriber1 created....");
	}
	
	
	@JmsListener(destination = "pradeep.topic")
   public void consume(String message) {
       System.out.println("*********  Topic Subriber1 : Received Message  :" + message);
   }


}
