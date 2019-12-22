package com.pradeep.kafka;
import java.util.Arrays;
import java.util.Properties;
import java.util.function.Supplier;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ManualConsumer{

    public static void main(String[] args) throws Exception{

        String topicName = "pradeep";
        String groupName = "SupplierTopicGroup";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
        props.put("group.id", groupName);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("enable.auto.commit", "false");

        KafkaConsumer<String, String> consumer = null;

        try {
            consumer = new KafkaConsumer<>(props);
          
            consumer.subscribe(Arrays.asList(topicName));

        	System.out.println("Waiting for the messages....");
            
            while (true){
                ConsumerRecords<String, String> records = consumer.poll(3000);
                for (ConsumerRecord<String, String> record : records){
                    System.out.println();
                    System.out.println("Message is received from  to Partition no " + record.partition() + " and offset " + record.offset()+" value  "+record.value());
                }
                
                consumer.commitAsync();
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            consumer.commitSync();
            consumer.close();
        }
    }
}
