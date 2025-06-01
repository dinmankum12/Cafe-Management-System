package com.dinesh.cafe.jwt;

import java.util.ArrayList;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dinesh.cafe.dao.UserDao;
import com.dinesh.cafe.serviceImpl.UserServiceImpl;
@Service
public class CustomerUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserDao userDao;
	
	final Logger log = LoggerFactory.getLogger(CustomerUserDetailsService.class);
	
	private com.dinesh.cafe.POJO.User userDetail;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		log.info("Inside loadUserByUsername {}",username);
		
		userDetail = userDao.findByEmailId(username);
		if(!Objects.isNull(userDetail)) 
			return new User(userDetail.getEmail(),userDetail.getPassword(),new ArrayList<>());
		else
			throw new UsernameNotFoundException("User not found.");
		
	}
	
	public com.dinesh.cafe.POJO.User getUserDetail(){
//		com.dinesh.cafe.POJO.User user = userDetails;
//		user.setPassword(null);
//		return user;
		return userDetail;
	}

	
	

}
