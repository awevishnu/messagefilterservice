package com.haud.messageproducer.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.haud.messageproducer.feignclient.NonSpamMessageSenderProxy;
import com.haud.messageproducer.model.MessageContent;
import com.haud.messageproducer.service.MessageFilterService;
import com.haud.messageproducer.source.MessageSenderSource;


@SuppressWarnings("deprecation")
@RestController
@EnableBinding(MessageSenderSource.class)
public class MessageSenderController {
	Logger logger = LogManager.getLogger(MessageSenderController.class);

    @Autowired
	MessageSenderSource msgSource;
    
      
    @Autowired
    MessageFilterService msgFilterService;
    
    @Autowired
    NonSpamMessageSenderProxy nonSpamProxy;
    
    @PostMapping("/sendMessage")
	public ResponseEntity<?> sendMessage(@RequestBody MessageContent msgContent)
	{
		msgSource.sendMessage().send(MessageBuilder.withPayload(msgContent).build());

		logger.info("Inside "+msgContent.getMessageContent());
		//this line is serializing the message and sending to rabbitmq
		if(!msgFilterService.checkValidMessage(msgContent.getMessageContent())) {
			nonSpamProxy.sendNonSpamMessage(msgContent);

		}
		
		return ResponseEntity.ok("Success");
		
	}

   
}
