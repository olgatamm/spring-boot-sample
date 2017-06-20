/*package com.sample.jms;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.sample.Application;
import com.sample.configs.JmsConfig;

public class JMSExample {
	public static void main(String[] args) throws URISyntaxException, Exception {
		BrokerService broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
		broker.start();
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(JmsConfig.class);

		try {
			MessageSender springJmsProducer = (MessageSender) context.getBean("messageSender");
			springJmsProducer.sendMessage("Hi");
		} finally {
			broker.stop();
			context.close();
		}
	}
}
*/