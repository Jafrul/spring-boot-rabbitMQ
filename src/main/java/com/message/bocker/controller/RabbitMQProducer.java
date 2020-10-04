	package com.message.bocker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.message.bocker.configure.RabbitMQSender;
import com.message.bocker.model.Employee;

@RestController
@RequestMapping(value = "/ahasan-rabbitmq/")
public class RabbitMQProducer {

	@Autowired
	private RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		rabbitMQSender.send(emp);
		return "Message sent to the RabbitMQ " + emp.getEmpName() + " Successfully";
	}

}
