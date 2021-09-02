package com.sachin.work.SpringKafkaExample;

import lombok.extern.java.Log;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log
public class AppKafkaConsumer {

    @KafkaListener(topics = "${app.default-topic}")
    public void receive(final ConsumerRecord<?, ?> consumerRecord) {
        log.info(String.format("Received payload: {%s}", consumerRecord.toString()));
    }
}
