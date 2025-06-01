package com.dinesh.cafe.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<String> signup(Map<String, String> requestMap);

	ResponseEntity<String> login(Map<String, String> requestMap);

}
