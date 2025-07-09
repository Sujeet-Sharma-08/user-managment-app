package com.usermanagementapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagementapp.model.User;

public interface UserRepository  extends JpaRepository<User, Long>{
	

}
