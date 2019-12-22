package com.pradeep.kafka;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class SupplierConsumer{

        public static void main(String[] args) throws Exception{

                String topicName = "SupplierTopic";
                String groupName = "SupplierTopicGroup";

                Properties props = new Properties();
                props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
                props.put("group.id", groupName);
                props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
                props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


                KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
                consumer.subscribe(Arrays.asList(topicName));

                while (true){
                        ConsumerRecords<String, String> records = consumer.poll(100);
                        for (ConsumerRecord<String, String> record : records){
                                System.out.println("Message : Key "+record.key()+" ,Message Value :"+record.value()+"  PArtition  "+record.partition()+"  Offset :"+record.offset());
                        }
                }

        }
}
