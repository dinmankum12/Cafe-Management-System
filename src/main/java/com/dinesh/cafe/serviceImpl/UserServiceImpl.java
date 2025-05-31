package com.dinesh.cafe.serviceImpl;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.dinesh.cafe.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
	

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		 final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
		log.info("inside signup {}", requestMap);
		return null;
	}
	private boolean validateSignUpMap(Map<String, String> requestMap) {
		if(requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
		&& requestMap.containsKey("email") && requestMap.containsKey("password"))
		{
			return true;
		}
		return false;
	}
	
}
