package com.springsecuritycrud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecuritycrud.dao.UserRepository;
import com.springsecuritycrud.model.CustomUsersDetail;
import com.springsecuritycrud.model.User;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = repo.findById(username);
		User user1 = null;
		if(user.isPresent()) {
			user1 = user.get();
			}
		else {
			throw new UsernameNotFoundException("Not found");
		}
		
		return new CustomUsersDetail(user1);
		
	}

}
