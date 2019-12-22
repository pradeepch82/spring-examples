package com.pradeep.kafka;
import java.util.*;
import org.apache.kafka.clients.producer.*;
public class SynchronousProducer {

   public static void main(String[] args) throws Exception{

      String topicName = "pradeep";
          String key = "Sachin";
          String value = "Sharma";

      Properties props = new Properties();
      props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
      props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
      props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

      Producer<String, String> producer = new KafkaProducer <>(props);

//       ProducerRecord<String, String> record = new ProducerRecord<>(topicName,key,value);

          
      try{
    	  for(int i=1;i<=10;i++) {
   ProducerRecord<String, String> record = new ProducerRecord<>(topicName,key+"=="+i,value+"========="+i);
  RecordMetadata metadata = producer.send(record).get();
  
  
           System.out.println("Message is sent to Partition no " + metadata.partition() + " and offset " + metadata.offset());
           
    	  }
    	  System.out.println("SynchronousProducer Completed with success.");
          
      }catch (Exception e) {
           e.printStackTrace();
           System.out.println("SynchronousProducer failed with an exception");
      }finally{
           producer.close();
      }
   }
}
