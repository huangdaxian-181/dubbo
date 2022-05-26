import kafka.KafkaConsumers;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.testng.annotations.Test;

import java.util.Properties;


@Slf4j
public class LoggerStartTest {

    @Test
    public void main() {
        KafkaConsumers kafkaConsumers = new KafkaConsumers();

        Properties properties = new Properties();

        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "group-1");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "3000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer consumer = kafkaConsumers.KafkaConsumer("localhost:9092","dubbo-kafka-logger");


        while (true){
            ConsumerRecords<String,String> records = consumer.poll(3000);

            for (ConsumerRecord<String,String> record:records
            ) {

                System.out.println("值:"+record.value());
            }
        }
    }
}