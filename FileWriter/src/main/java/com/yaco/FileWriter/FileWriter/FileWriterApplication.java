package com.yaco.FileWriter.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Retry.Topic;
import org.springframework.context.ConfigurableApplicationContext;

import com.yaco.FileWriter.FileWriter.MQ.Reciever;
import com.yaco.FileWriter.FileWriter.lib.FileWriter;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class FileWriterApplication {

	static final String topic = "yaco-file-writer";
	static final String queueName = "yaco-file-writer-queue";

	@Bean
	Queue queue() {
		return new Queue(this.queueName, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topic);
	}


	@Bean
	Binding binding(Queue queue, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange).with("foo.bar.#");
	} 


	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Reciever reciever) {
		return new MessageListenerAdapter(reciever, "recieveMessage");
	}


	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(FileWriterApplication.class, args);
		FileWriter fileWriter = context.getBean(FileWriter.class);


		 System.out.println("🚀 File Writer Service");
	}

}
