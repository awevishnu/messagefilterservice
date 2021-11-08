package com.haud.messageproducer.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

@SuppressWarnings("deprecation")
public interface MessageSenderSource {
	@Output("smsChannel")
	MessageChannel sendMessage();

}
