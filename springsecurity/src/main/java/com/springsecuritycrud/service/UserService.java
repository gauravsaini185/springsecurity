package com.springsecuritycrud.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecuritycrud.dao.UserRepository;
import com.springsecuritycrud.model.User;

@Service
public class UserService {
	

	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUser(String id) {
		Optional<User> optional =  userRepository.findById(id);
		User user1 = null;
		if(optional.isPresent()) {
			user1 = optional.get();
		}
		else {
			throw new RuntimeException("No User Found of username : " + id);
		}
		
		return user1;
		}

	public void saveUser(User user) {
		userRepository.save(user);
	
		
	}


	public void updateUser(User user) {
		User existingUser = userRepository.findById(user.getUsername()).orElse(null);
		existingUser.setEmail(user.getEmail());
		existingUser.setName(user.getName());;
		existingUser.setPassword(user.getPassword());
		existingUser.setUsername(user.getUsername());
		userRepository.save(existingUser);
	}

	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}

	
	
}
