import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 消费者程序，主要是用来连接kafka，并不断拉取kafka中的日志消息，打印到console中。
 * @author shishanli
 * @date 2021年1月15日16:39:27
 */
public class SimpleConsumer {


    private  final Logger logger = LoggerFactory.getLogger(SimpleConsumer.class);
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "test-group");
        KafkaConsumer kafkaConsumer = new KafkaConsumer(properties);
        List topics = new ArrayList();
        //订阅的topic，多个用逗号隔开
        topics.add("error-log");
        kafkaConsumer.subscribe(topics);
        try {
            while (true) {
                ConsumerRecords consumerRecords = kafkaConsumer.poll(10);
                for (Object consumerRecord : consumerRecords) {
                    ConsumerRecord record = (ConsumerRecord) consumerRecord;
                    System.out.println(String.format("Topic - %s, Partition - %d, Value: %s",
                            record.topic(), record.partition(), record.value()));
                }
            }
        } finally {
            kafkaConsumer.close();
        }
    }
}
