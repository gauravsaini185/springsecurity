package com.springsecuritycrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springsecuritycrud.dao.UserRepository;
import com.springsecuritycrud.model.User;

@SpringBootApplication
public class SpringsecurityApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user = new User();
		user.setEmail("gaurav@gmail.com");
		user.setName("Gaurav");
		user.setPassword(this.passEncoder.encode("gaurav"));
		user.setUsername("gaurav");
		user.setRole("ROLE_ADMIN");
		userRepo.save(user);
		
		User user1 = new User();
		user1.setEmail("saurav@gmail.com");
		user1.setName("Saurav");
		user1.setPassword(this.passEncoder.encode("saurav"));
		user1.setUsername("sauarv");
		user1.setRole("ROLE_NORMAL");
		userRepo.save(user1);
		
		
		
	}

	
	
}
