package com.sachin.work.SpringKafkaExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringKafkaExampleApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(SpringKafkaExampleApplication.class, args);
		Thread.currentThread().sleep(10_000);
	}

}
