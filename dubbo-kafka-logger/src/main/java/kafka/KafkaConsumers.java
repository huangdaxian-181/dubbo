package kafka;

import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * 消费者
 *
 * @author 搬砖的码农
 * @date 2022/05/25
 * @email
 **/
public class KafkaConsumers {
    public KafkaConsumer KafkaConsumer(String servers, String topic) {
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


    public void rendMessage(KafkaConsumer<String, String> kafkaConsumer, int timeout) {
        while (true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(timeout);

            for (ConsumerRecord<String, String> records : consumerRecords
            ) {
                System.out.println(records);
            }
        }

    }
}
