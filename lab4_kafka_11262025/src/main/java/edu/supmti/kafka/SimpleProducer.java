package edu.supmti.kafka;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;

public class SimpleProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        
        Producer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> record = 
            new ProducerRecord<>("Hello-Kafka", "key", "Hello from Java Producer - Lab 4 Completed!");
        producer.send(record);
        System.out.println("Lab 4 Kafka message sent!");
        producer.close();
    }
}
