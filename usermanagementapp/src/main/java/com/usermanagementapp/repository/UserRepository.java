package com.usermanagementapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagementapp.model.User;




public interface UserRepository  extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);
	
}
