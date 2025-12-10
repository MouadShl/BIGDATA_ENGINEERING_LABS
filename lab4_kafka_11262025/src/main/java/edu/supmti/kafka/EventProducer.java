package edu.supmti.kafka;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;

public class EventProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        
        Producer<String, String> producer = new KafkaProducer<>(props);
        
        try {
            for (int i = 1; i <= 10; i++) {
                String message = "Message " + i + " from Java Producer";
                
                ProducerRecord<String, String> record = new ProducerRecord<>(
                    "Hello-Kafka", 
                    "key-" + i, 
                    message
                );
                
                producer.send(record, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (exception == null) {
                            System.out.println("Message sent to partition " + 
                                              metadata.partition() + " at offset " + 
                                              metadata.offset());
                        } else {
                            exception.printStackTrace();
                        }
                    }
                });
                
                Thread.sleep(500);
            }
            
            System.out.println("10 messages sent successfully!");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
