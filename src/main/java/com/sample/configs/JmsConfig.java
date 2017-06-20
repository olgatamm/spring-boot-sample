/*package com.sample.configs;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import com.sample.jms.MessageReceiver;
import com.sample.jms.MessageSender;

@Configuration
public class JmsConfig {
	private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
	private static final String ORDER_QUEUE = "order-queue";
	private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";

	@Autowired
	MessageReceiver messageReceiver;
	
	@Autowired
	MessageSender messageSender;

	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		connectionFactory.setTrustedPackages(Arrays.asList("com.sample"));
		return connectionFactory;
	}

	@Bean
	public MessageListenerContainer getContainer() {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setDestinationName(ORDER_RESPONSE_QUEUE);
		container.setMessageListener(messageReceiver);
		return container;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(ORDER_QUEUE);
		return template;
	}

	@Bean
	MessageConverter converter() {
		return new SimpleMessageConverter();
	}

}
*/