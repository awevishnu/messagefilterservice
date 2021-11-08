package com.haud.messageproducer.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.haud.messageproducer.service.MessageFilterService;

@Service
public class MessageFilterServiceImpl implements MessageFilterService{
	public boolean checkValidMessage(String strMessage)
	{
		List<String> blackListedWords=Arrays.asList("Act now","100% free","Cash bonus","Click here", 
				"Earn extra cash", "Free gift");
		   boolean match = blackListedWords.stream().anyMatch(strMessage::contains);
        return match;
	}

	public void checkIfDestinationAllowed(String destinationId)
	{
		
	}
}
