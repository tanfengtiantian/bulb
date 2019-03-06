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
        Properties prop = new Properties();
        prop.put("bootstrap.servers", "47.98.199.80:9092");
        prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer kafkaProducer = new KafkaProducer(prop);
        // 消息内容
        ProducerRecord<String, String> record = new ProducerRecord<>("test", "user","hello kafka");
        kafkaProducer.send(record);
        kafkaProducer.close();
        System.out.println("Producer end ...");
    }
}
