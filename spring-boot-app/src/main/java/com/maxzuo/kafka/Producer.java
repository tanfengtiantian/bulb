package com.maxzuo.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * 生产者
 * Created by zfh on 2018/10/14
 */
public class Producer {

    public static void main (String[] args) {
        Properties var1 = new Properties();
        var1.put("bootstrap.servers", "127.0.0.1:9092");
        var1.put("metadata.broker.list", "localhost:9092");
        var1.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        var1.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer kafkaProducer = new KafkaProducer(var1);
        // 消息内容
        ProducerRecord<String, String> record = new ProducerRecord<>("test-topic", "name", "hello");
        kafkaProducer.send(record);
        kafkaProducer.close();
        System.out.println("Producer end ...");
    }
}
