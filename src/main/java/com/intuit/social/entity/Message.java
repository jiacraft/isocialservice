package com.intuit.social.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Message implements Serializable {

	/**
	 * 	generated
	 */
	private static final long serialVersionUID = 3274385866213647339L;
	
	private @Id @GeneratedValue Long id;
	
	private String msg;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private User user;
	
	private long timeMs;
	
	public Message () {;}
	
	public Message (String msg, User user) {
		this.msg = msg;
		this.user = user;
		this.timeMs = (Calendar.getInstance()).getTimeInMillis();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getMsg() {
		return msg;
	}

	public User getUser() {
		return this.user;
	}

	public long getTimeMs() {
		return timeMs;
	}
	
}
