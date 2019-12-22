package com.pradeep.kafka.consumer;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.function.Supplier;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class NewSupplierConsumer{

    public static void main(String[] args) throws Exception{

        String topicName = "SupplierTopic";
        String groupName = "SupplierTopicGroup";
        Properties props = new Properties();
        //props.put("bootstrap.servers", "localhost:9092,localhost:9093");
        //props.put("group.id", groupName);
        //props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        //props.put("value.deserializer", "SupplierDeserializer");

        InputStream input = null;
        KafkaConsumer<String, Supplier> consumer = null;

        try {
            input = new FileInputStream("SupplierConsumer.properties");
            props.load(input);
            consumer = new KafkaConsumer<>(props);
            consumer.subscribe(Arrays.asList(topicName));

            while (true){
                ConsumerRecords<String, Supplier> records = consumer.poll(100);
                for (ConsumerRecord<String, Supplier> record : records){
                    System.out.println("Supplier id= " + String.valueOf(record.value().get()) + " Supplier  Name = " + record.value().get() + " Supplier Start Date = " + record.value().toString());
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            input.close();
            consumer.close();
        }
    }
}
