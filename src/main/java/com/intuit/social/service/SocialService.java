package com.intuit.social.service;

import java.util.List;

import com.intuit.social.entity.Message;

public interface SocialService {
	
	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	public List<Message> getLatestOneHundredMessages(String ownerId);
}
