package com.maxzuo.kafka;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * Kafka Streams流处理程序
 * Created by zfh on 2019/03/06
 */
public class StreamsExample {

    private static final Logger logger            = LoggerFactory.getLogger(StreamsExample.class);

    /** test：47.98.199.80:9092 cluster：192.168.3.192:9090,192.168.3.191:9090,192.168.3.181:9090 */
    private static final String BOOTSTRAP_SERVERS = "47.98.199.80:9092";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-pipe");
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        StreamsConfig config = new StreamsConfig(props);

        KStreamBuilder builder = new KStreamBuilder();
        KStream<Object, Object> source = builder.stream("test").mapValues(value -> {
            logger.info("value: {}", new String((byte[]) value));
            return value;
        });
        /// 投递到新的topic上
        //source.to("output-topic");

        final KafkaStreams streams = new KafkaStreams(builder, config);
        final CountDownLatch latch = new CountDownLatch(1);

        // 捕获用户中断，并在终止该程序时关闭客户端
        Runtime.getRuntime().addShutdownHook(new Thread("kafka-stream-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });
        try {
            // start()函数，触发客户端的执行。在此客户端上调用close()之前，执行不会停止。
            streams.start();
            latch.await();
        } catch (Exception e) {
            System.exit(1);
        }
        System.exit(0);
    }
}
