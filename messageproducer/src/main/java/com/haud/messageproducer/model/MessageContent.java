package com.haud.messageproducer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MessageContent {
	
	private String sender;
	
	private String messageContent;
	
	private String destination;

}
