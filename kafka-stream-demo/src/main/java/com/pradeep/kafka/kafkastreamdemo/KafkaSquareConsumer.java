package com.pradeep.kafka.kafkastreamdemo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaSquareConsumer {
	
	public KafkaSquareConsumer() {
	System.out.println("KafkaSquareConsumer created.....");
	}

    @KafkaListener(topics = "${kafka.topic.output}")
    public void consume(Long number)  {
        System.out.println(String.format("Consumed :: %d", number));
    }

}