package com.dinesh.cafe.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.cafe.constents.CafeConstants;
import com.dinesh.cafe.rest.UserRest;
import com.dinesh.cafe.service.UserService;
import com.dinesh.cafe.utils.CafeUtils;

@RestController
public class UserRestImpl implements UserRest{
	
	@Autowired
	UserService userService;

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			
			return userService.signUp(requestMap);			
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}

		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
