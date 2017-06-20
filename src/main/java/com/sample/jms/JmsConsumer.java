package com.sample.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sample.models.User;

@Component
public class JmsConsumer {

	@JmsListener(destination = "users", containerFactory = "messageFactory")
	public void receiveMessage(User user) {
		System.out.println("Received a user: " + user.getEmail());
	}

}
