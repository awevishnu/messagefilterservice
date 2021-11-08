package com.haud.successmessagesender.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.haud.successmessagesender.channel.MesageSenderChannel;
import com.haud.successmessagesender.model.MessageContent;

@RestController
public class SuccessMessageSenderController {

	Logger logger = LogManager.getLogger(SuccessMessageSenderController.class);

	@Autowired
	MesageSenderChannel senderChannel;

	@PostMapping("/sendNonSpamMessage")
	public ResponseEntity<?> sendNonSpamMessage(@RequestBody MessageContent msgContent) {
		logger.info("Inside " + msgContent.getMessageContent());
		// this line is serializing the message and sending to rabbitmq
		senderChannel.sendMessage().send(MessageBuilder.withPayload(msgContent).build());

		return ResponseEntity.ok("Success");

	}

}
