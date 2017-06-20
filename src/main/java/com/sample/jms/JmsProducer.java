package com.sample.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.sample.models.User;

@Component
public class JmsProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(User user) {
		this.jmsTemplate.convertAndSend("users", user);
	}

}
