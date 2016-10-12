package com.intuit.social.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4236958924670287975L;

	@Id @GeneratedValue
	private Long id;
	
	private String uid;
	
	private String lastName;
	
	private String firstName;
	
	
	// list of followed users
	// private Set<User> followedUsers;

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
	
	/*
	public Set<User> getFollowedUsers() {
		return followedUsers;
	}

	public void setFollowedUsers(Set<User> followedUsers) {
		this.followedUsers = followedUsers;
	}
	
	public void addFollowedUser(User u) {
		
		if(followedUsers == null) {
			followedUsers = new HashSet<User> ();
		}
		if(followedUsers.contains(u)) {
			return;
		}
		
		this.followedUsers.add(u);
	}
	
	public void deleteFollowedUser(User u) {
		if(followedUsers != null && followedUsers.contains(u)) {
			followedUsers.remove(u);
		}
	} */

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String toString() {
		return "First Name: " + this.firstName + ", Last Name: " + this.lastName;
	}
}
