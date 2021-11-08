package com.haud.messageproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.haud.messageproducer.source.MessageSenderSource;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableBinding(MessageSenderSource.class)
public class MessageproducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageproducerApplication.class, args);
	}

}
