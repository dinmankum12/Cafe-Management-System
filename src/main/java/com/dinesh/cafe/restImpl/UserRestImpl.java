package com.dinesh.cafe.restImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.cafe.constents.CafeConstants;
import com.dinesh.cafe.rest.UserRest;
import com.dinesh.cafe.service.UserService;
import com.dinesh.cafe.utils.CafeUtils;
import com.dinesh.cafe.wrapper.UserWrapper;

@RestController
public class UserRestImpl implements UserRest{
	
	@Autowired
	UserService userService;

	@Override
	public ResponseEntity<String> signup(Map<String, String> requestMap) {
		try {
			return userService.signup(requestMap);			
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}

		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		try {
			return userService.login(requestMap);			
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}

		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<UserWrapper>> getAllUser() {
		try {
			return userService.getAllUser();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<UserWrapper>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> update(Map<String, String> requestMap) {
		try {
			return userService.update(requestMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
