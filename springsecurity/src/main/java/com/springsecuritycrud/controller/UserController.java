package com.springsecuritycrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecuritycrud.model.User;
import com.springsecuritycrud.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public List<User> getAll(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") String id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/")
	public void save(@RequestBody User user) {
		userService.saveUser(user);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		userService.deleteUser(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody User user) {
		userService.updateUser(user);
	}
}
