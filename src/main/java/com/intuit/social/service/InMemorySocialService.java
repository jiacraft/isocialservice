package com.intuit.social.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.intuit.social.dao.MessageRepository;
import com.intuit.social.dao.UserFollowerRepository;
import com.intuit.social.dao.UserRepository;
import com.intuit.social.entity.Message;
import com.intuit.social.entity.User;
import com.intuit.social.entity.FollowedUser;

@Component(value = "inMemory")
public class InMemorySocialService implements SocialService {

	private static final Logger logger = Logger
			.getLogger(InMemorySocialService.class);
	
	@Autowired
	private MessageRepository msgRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserFollowerRepository userFollowerRepo;
	
	//TODO:  Mocked messages
	private static List<Message> mockedMsgs = new ArrayList<Message> ();
	
	@Override
	public List<Message> getLatestOneHundredMessages(String userId) {
		logger.info("retrieve latest 100 message for user id [" + userId + "]");
		
		User nUser = new User();
		nUser.setFirstName("bruce");
		nUser.setLastName("jia");
		
		userRepo.save(nUser);
		
		
		//User user = userRepo.findOne(Long.valueOf(2));
		List<User> users = userRepo.findAll();
		
		if(users == null) {
			logger.info("no users");
		} else {
			logger.info("first user: " + users.get(0).getFirstName() + "; " + users.get(0).getLastName());
		}
		
		User fUser = new User();
		fUser.setFirstName("frank");
		fUser.setLastName("lao");
		
		
		userRepo.save(fUser);
		
		FollowedUser fuPair = new FollowedUser (nUser, fUser);
		
		userFollowerRepo.save(fuPair);
		
		Message msg = new Message("my first tweek on Oct. 10, 2016", fUser);
		msgRepo.save(msg);
		Message msg2 = new Message("my second tweek on Oct. 10, 2016", fUser);
		msgRepo.save(msg2);
		
		//List<Message> msgs = msgRepo.findAll();
		// logger.info("there are: " + msgs.size() + " messages.");
		
		// List<Message> msgs = msgRepo.findByUser(nUser);
		PageRequest pageRequest =
			    new PageRequest(0, 100, Sort.Direction.DESC, "timeMs");
		Page<Message> msgPage = msgRepo.findByUser(nUser, pageRequest);
		
		logger.info("there are: " + msgPage.getContent().size() + " messages.");
		logger.info("user of message : " + msgPage.getContent().get(0).getUser().toString());
		
		logger.info("id of message : " + msgPage.getContent().get(0).getId());
		
		
		
	
		
		List<FollowedUser> fu = userFollowerRepo.findAll();
		logger.info("size of FollowedUser : " + fu.size());
		
		users = userRepo.findAll();
		logger.info("there are current : " + users.size() + " users.");
		
		messageGenerator();
		return mockedMsgs;
		
		
	}
	
	@PostConstruct
    public void messageGenerator() {	
		// generate messages and persist inmemory 
		for (int i = 1; i <= 100; i++) {
			User u = new User();
			Message msg = new Message ("Social Service Sample Msg " + i, u);
			mockedMsgs.add(msg);
			// msgRepo.save(msg);
			
		}
		
		// set followers
		/*
		User user = userRepo.findOne(Long.valueOf(2));
		User follower = userRepo.findOne(Long.valueOf(10));
		User follower1 = userRepo.findOne(Long.valueOf(11));
		User follower2 = userRepo.findOne(Long.valueOf(12));
		
		userFollowerRepo.save(new UserFollower(user, follower));
		userFollowerRepo.save( new UserFollower(user, follower1));
		userFollowerRepo.save( new UserFollower(user, follower2));
		*/
		
		return;
	}

}
