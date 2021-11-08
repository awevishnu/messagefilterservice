package com.haud.successmessagesender.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MesageSenderChannel {
	@Output("successSmsChannel")
	MessageChannel sendMessage();

}
