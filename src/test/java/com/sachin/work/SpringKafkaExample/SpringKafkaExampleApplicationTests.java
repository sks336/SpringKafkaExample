package com.sachin.work.SpringKafkaExample;

import com.github.javafaker.Faker;
import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

@Log
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class SpringKafkaExampleApplicationTests {

	@Autowired
	private ApplicationContext context;

	private Faker faker;

	@Value("${app.default-topic:default-topic}")
	private String DEFAULT_TOPIC;

	@Autowired
	private AppKafkaProducer appKafkaProducer;


	@BeforeEach
	public void setUp() {
		faker = new Faker();
	}

	@AfterEach
	public void shutDown() throws InterruptedException {
		Thread.currentThread().sleep(2_000);
		log.info("Test Execution Completed!!");
	}

	@Test
	void contextLoads() {
		Assert.notNull(this.context, "Application context cannot be null");
	}


	@Test
	void sendSampleHelloMessagesToDefaultTopic() {
		final String msg = String.format("Hello %s!!", faker.name().fullName());
		this.appKafkaProducer.send(DEFAULT_TOPIC,  msg);
	}

}
