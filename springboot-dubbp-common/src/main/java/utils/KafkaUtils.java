package utils;

import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;

/**
 * kafka工具类
 *
 * @author 搬砖的码农
 * @date 2022/05/25
 * @email
 **/
public class KafkaUtils {
    /**
     * 消费者
     */
    public static KafkaConsumer<String, String> createConsumer(String servers, String topic) {
        Properties properties = new Properties();

        properties.put("bootstrap.servers", servers);
        properties.put("group.id", "group-1");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);

        kafkaConsumer.subscribe(Arrays.asList(topic));

        return kafkaConsumer;
    }


    public static void readMessage(KafkaConsumer<String, String> kafkaConsumer, int timeout) {

        while (true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(timeout);

            System.out.println(13131);
            for (ConsumerRecord<String, String> records : consumerRecords) {

                System.out.println(records);
            }

        }
    }

    public static KafkaProducer<String, String> createProducer(String servers) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", servers);
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<String, String>(properties);
    }

    public static void send(KafkaProducer<String, String> producer, String topic, String message) {
        producer.send(new ProducerRecord<String, String>(topic, message));
    }
}
