package com.intuit.social.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author bruce.jia
 * @DateTime Aug 23, 201612:06:25 PM
 * @version 
 */
@Entity
public class FollowedUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3468285133608406672L;
	
	private @Id @GeneratedValue Long id;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private User user;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private User followedUser;
	
	public FollowedUser() {
		;
	}
	
	public FollowedUser(User u, User f) {
		this.user = u;
		this.followedUser = f;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the follower
	 */
	public User getFollowedUser() {
		return followedUser;
	}

	/**
	 * @param follower the follower to set
	 */
	public void setFollowedUser(User fu) {
		this.followedUser = fu;
	}
	
}
