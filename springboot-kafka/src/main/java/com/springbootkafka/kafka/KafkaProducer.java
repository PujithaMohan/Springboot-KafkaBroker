package com.springbootkafka.kafka;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
@Service
public class KafkaProducer {
    @Value("${spring.kafka.topic.name}")
    private String topicName;
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);

    public KafkaProducer(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        LOGGER.info(String.format("#### -> Producing message -> %s",message));
        kafkaTemplate.send(topicName,message);
    }
}
