package com.se.producer;

import com.se.model.event.EventDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageBrokerService {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void pushRequestPaymentOrder() {

        EventDto eventDto = new EventDto();
        eventDto.setType("Available");
        eventDto.setBedId(100060);

        try {
            this.jmsTemplate.convertAndSend("TopicDemo", eventDto);
            log.info("Message sent successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
