package com.usermanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.usermanagementapp.DTO.ChangePasswordDTO;
import com.usermanagementapp.DTO.UserDTO;
import com.usermanagementapp.service.UserService;

@RestController
@RequestMapping
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	// getting user by id
	@GetMapping("/getuserbyid/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
		
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	
	// getting user by username
	@GetMapping("/getuserbyusername/{username}")
	public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username){
		
		return ResponseEntity.ok(userService.getUserByUsername(username));
		
	}
	
	
	
	// getting all the users
	@GetMapping("/getalluser")
	public List<UserDTO> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	
	@PutExchange("/changepassword/{id}")
	public ResponseEntity<UserDTO> changePassword(@PathVariable Long id, ChangePasswordDTO changePasswordDto){
		
		return ResponseEntity.ok(userService.changePassword(id, changePasswordDto));
		
	}
	
 	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
		return ResponseEntity.ok(userService.updateUser(id, userDTO));
	}
	
	
	// deleting  the user
	
	@DeleteMapping("deleteuserbyid/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
		 ResponseEntity.ok(id);
		 return ResponseEntity.ok().build();
	}
}
