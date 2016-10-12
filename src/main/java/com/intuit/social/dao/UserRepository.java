package com.intuit.social.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intuit.social.entity.User;

/**
 *
 * @author bruce.jia
 * @Date Aug 23, 2016
 * @version 
 */
public interface UserRepository extends JpaRepository<User, Long>{

}
