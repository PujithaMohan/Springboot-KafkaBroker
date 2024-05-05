package com.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springbootkafka.model.User;

@Service
public class JsonKafkaConsumer
{
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
@KafkaListener(topics = "${spring.kafka.topic_json.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user){
    LOGGER.info(String.format("Consumed message %s",user.toString()));
    }
}
