/*
 * UserController Without JPA
package com.cts.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.Dao.UserDaoImpl;
import com.cts.model.Users;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@GetMapping(path = "/Users")
	public List<Users> getAllUsers(){
		List<Users> users = userDaoImpl.findAll(); 
		return users;
	}
	
	@GetMapping("/Users/{id}")
	public Users getById(@PathVariable int id) {
		return userDaoImpl.findById(id);
	}
	
	@PostMapping("/Users")
	public Users saveUser(@Valid @RequestBody Users user) {
		 Users savedUser = userDaoImpl.save(user);
		 return savedUser;
	}

}
 */

package com.cts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Users;
import com.cts.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	
	@GetMapping(path = "/Users")
	public List<Users> getAllUsers(){
		List<Users> users = repository.findAll(); 
		return users;
	}
	
	@GetMapping("/Users/{id}")
	public Users getById(@PathVariable int id) {
		Users user = repository.findById(id).get();
		return user;
	}
	
	@PostMapping("/Users")
	public Users saveUser(@Valid @RequestBody Users user) {
		 Users savedUser = repository.save(user);
		 return savedUser;
	}
	
	@DeleteMapping("/Users/{id}")
	public void deleteById(@PathVariable int id) {
		repository.deleteById(id);
		
	}
}
