package com.se.consumer;

import com.se.model.event.EventDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Slf4j
@SpringBootApplication
public class ConsumerArtemisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerArtemisApplication.class, args);
	}

	@JmsListener(destination = "TopicDemo")
	public void receiveMessageRegisterUpdateStudent(EventDto event) {
		log.info("Read Message From Topic");
		log.info("Type: " + event.getType());
		log.info("Id of the bead: " + event.getBedId());

		//Perform the upgrade that is available that bed
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

}
