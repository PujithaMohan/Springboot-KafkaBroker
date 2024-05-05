package com.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.springbootkafka.model.User;

@Service
public class JsonKafkaProducer {
    @Value("${spring.kafka.topic_json.name}")
    private String topicName;
    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaProducer.class);
    public JsonKafkaProducer(final KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User data){
        LOGGER.info(String.format("Message sent %s",data.toString()));
        Message<User> message= MessageBuilder
                .withPayload(data).setHeader(KafkaHeaders.TOPIC, topicName).build();
        kafkaTemplate.send(message);
    }

}
