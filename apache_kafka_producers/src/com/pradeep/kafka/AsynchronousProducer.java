package com.pradeep.kafka;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class AsynchronousProducer {

   public static void main(String[] args) throws Exception{
      String topicName = "pradeep";
          String key = "Mangesh";
          String value = "Sharma";

      Properties props = new Properties();
      props.put("bootstrap.servers", "localhost:9092,localhost:9093");
      props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
      props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

      Producer<String, String> producer = new KafkaProducer <>(props);

      ProducerRecord<String, String> record = new ProducerRecord<>(topicName,key,value);

      
      producer.send(record, new MyProducerCallback());
      
      System.out.println("AsynchronousProducer call completed");
      producer.close();

   }

}

    class MyProducerCallback implements Callback{

       @Override
       public  void onCompletion(RecordMetadata metadata, Exception e) {
        if (e != null)
            System.out.println("AsynchronousProducer failed with an exception");
                else {
                    System.out.println("Message is sent to Partition no " + metadata.partition() + " and offset " + metadata.offset());
                    
                	System.out.println("AsynchronousProducer call Success:");
                }
        
                }
   
    }
