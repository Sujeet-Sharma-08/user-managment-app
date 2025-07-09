package com.usermanagementapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagementapp.DTO.UserDTO;
import com.usermanagementapp.model.User;
import com.usermanagementapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public UserDTO getUserById(Long id){
		User user = userRepository.getById(id).orElseThrow(()->new RuntimeException("User not found!"));
		return convertToUserDTO(user);
	}
	
	public UserDTO convertToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUsername(user.getUsername());
		userDTO.setEmail(user.getEmail());
		return userDTO;
	}
	
	
	// getting the user by user name
	public UserDTO getUserByUsername(String username) {
		User user = userRepository.findByUsername(username).orElseThrow(()->new RuntimeException("User not found!"));
		return convertToUserDTO(user);
	}
	
	
	// getting all the users
	public List<UserDTO> getAllUsers(){
		
		List<User> listOfUsers = userRepository.findAll();
		
		List<UserDTO> allDtoUsers = new ArrayList<>();
		
		for(User user : listOfUsers) {
			allDtoUsers.add(convertToUserDTO(user));	
		}
		return allDtoUsers;
	}
}
