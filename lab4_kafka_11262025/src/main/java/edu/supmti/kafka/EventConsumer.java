package edu.supmti.kafka;

import org.apache.kafka.clients.consumer.*;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class EventConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "java-consumer-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "earliest");
        
        Consumer<String, String> consumer = new KafkaConsumer<>(props);
        
        try {
            consumer.subscribe(Collections.singletonList("Hello-Kafka"));
            System.out.println("Subscribed to topic: Hello-Kafka");
            
            int messagesReceived = 0;
            while (messagesReceived < 10) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("Received message:");
                    System.out.println("  Key: " + record.key());
                    System.out.println("  Value: " + record.value());
                    System.out.println("  Partition: " + record.partition());
                    System.out.println("  Offset: " + record.offset());
                    System.out.println("---------------------------");
                    
                    messagesReceived++;
                }
            }
            
            System.out.println("Successfully received " + messagesReceived + " messages!");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }
}
