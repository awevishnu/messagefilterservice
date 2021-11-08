package com.haud.messageproducer.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haud.messageproducer.model.MessageContent;

import feign.Headers;


@FeignClient(name="successmessage-producer-service", url = "http://localhost:9091", configuration = MesageSenderAPIConfiguration.class)
public interface NonSpamMessageSenderProxy {

	@PostMapping("/sendNonSpamMessage")
    @Headers("Content-Type: application/json")
	public ResponseEntity<?> sendNonSpamMessage(@RequestBody MessageContent msgContent);
}
