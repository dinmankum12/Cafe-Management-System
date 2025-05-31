package com.dinesh.cafe.rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/user")
public interface UserRest {
	
	@PostMapping(path = "/singUp")
	public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String,String> requestMap);

}
