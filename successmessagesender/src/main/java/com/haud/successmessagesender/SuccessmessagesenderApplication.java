package com.haud.successmessagesender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.haud.successmessagesender.channel.MesageSenderChannel;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding(MesageSenderChannel.class)
public class SuccessmessagesenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuccessmessagesenderApplication.class, args);
	}

}
