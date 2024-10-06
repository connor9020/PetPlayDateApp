package com.PetPlayDateApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PetPlayDateApp.entity.User;
import com.PetPlayDateApp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Long uid) {
		return userRepository.findById(uid);
	}
	
	public User updateUser(Long uid, User userDetails) {
		Optional<User> existingUser = userRepository.findById(uid);
		if (existingUser.isPresent()) {
			User user = existingUser.get();
			user.setName(userDetails.getName());
			user.setEmail(userDetails.getEmail());
			user.setPassword(userDetails.getPassword());
			user.setPhoneNumber(userDetails.getPhoneNumber());
			
			return userRepository.save(user);
		} else {
			throw new RuntimeException("User not found with uid: "+ uid);
		}
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}