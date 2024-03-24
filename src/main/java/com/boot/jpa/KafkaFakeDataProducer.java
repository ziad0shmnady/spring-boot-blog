
package com.boot.jpa;

import org.apache.kafka.clients.producer.*;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.boot.jpa.model.Auther;
import com.boot.jpa.reporsitories.AutherRepository;

import jakarta.websocket.SendResult;

import java.util.Properties;

@SpringBootApplication
public class KafkaFakeDataProducer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); // Kafka broker addresses
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); // Key serializer
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); // Value serializer

        // Create a KafkaProducer instance
        Producer<String, String> producer = new KafkaProducer<>(props);

        // // Define the topic to which you want to send the messages
        String topic = "kafkademo";

        try {
            // Produce fake data to Kafka
            for (int i = 0; i < 10; i++) {
                String key = "key_" + i; // Unique key for each message
                String value = "FakeData_" + i; // Fake data
                ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

                // Send the message asynchronously
                producer.send(record, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (exception != null) {
                            // Handle error
                            exception.printStackTrace();
                        } else {
                            System.out.println("Message sent successfully! Topic: " + metadata.topic() +
                                    ", Partition: " + metadata.partition() + ", Offset: " + metadata.offset());
                        }
                    }
                }).get(); // Synchronous send, you can also use asynchronous send without get()
            }

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (java.util.concurrent.ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // Close the producer when finished
            producer.close();
        }

        // System.setProperty("server.port", "3000");
        // SpringApplication.run(JpaApplication.class, args);
    }
}
