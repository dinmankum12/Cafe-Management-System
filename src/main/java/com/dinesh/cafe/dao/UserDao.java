package com.dinesh.cafe.dao;

import java.util.List;

import javax.persistence.NamedQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dinesh.cafe.POJO.User;
import com.dinesh.cafe.wrapper.UserWrapper;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmailId(@Param("email") String email);

	@Query("SELECT new com.dinesh.cafe.wrapper.UserWrapper(u.id, u.name, u.email, u.contactNumber, u.status) FROM User u WHERE u.role = 'user'")
	List<UserWrapper> getAllUsers();
	
	@Query("SELECT u.email FROM User u WHERE u.role = 'admin'")
	List<String> getAllAdmin();

	@Query("update User u set u.status=:status where u.id=:id")
	@Transactional
	@Modifying
	Integer updateStatus(@Param("status") String status, @Param("id") Integer id);



}
