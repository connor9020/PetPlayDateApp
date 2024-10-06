package com.PetPlayDateApp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PetPlayDateApp.entity.Pet;
import com.PetPlayDateApp.entity.User;
import com.PetPlayDateApp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{uid}")
	public Optional<User> getUserById(@PathVariable Long uid) {
		return userService.getUserById(uid);
	}
	
//    @PostMapping
//    public Map<String, Object> signIn(@RequestBody User user) {
//        return userService.signIn(user);
//    }

    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

	@PutMapping("/{uid}")
	public User updateUser (@PathVariable Long uid, @RequestBody User userDetails) {
		return userService.updateUser(uid,  userDetails);
	}
	
	@DeleteMapping("/{uid}")
	public void deleteUser(@PathVariable Long uid) {
		userService.deleteUser(uid);
	}

}
