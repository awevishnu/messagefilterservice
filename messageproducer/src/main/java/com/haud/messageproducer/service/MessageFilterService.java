package com.haud.messageproducer.service;

public interface MessageFilterService {
	public boolean checkValidMessage(String strMessage);

	public void checkIfDestinationAllowed(String destinationId);
}
