package com.sachin.work.SpringKafkaExample;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Log
@Component
public class AppKafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(final String topic, final String payload) {
        log.info(String.format("Sending payload: {%s} to topic: {%s}", payload, topic));
        this.kafkaTemplate.send(topic, payload);
    }
}
