package com.intuit.social.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.intuit.social.entity.Message;

@Component(value="mySql")
public class MySqlDBSocialService implements SocialService {

	@Override
	public List<Message> getLatestOneHundredMessages(String ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
