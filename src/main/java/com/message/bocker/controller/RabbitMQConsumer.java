package com.message.bocker.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.message.bocker.model.Employee;


@Component
public class RabbitMQConsumer {

	@RabbitListener(queues = "${ahasan.rabbitmq.queue}")
	public void recievedMessage(Employee employee) {
		System.out.println("Recieved Message From RabbitMQ: " + employee);
	}
}