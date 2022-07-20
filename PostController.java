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

import com.cts.model.Post;
import com.cts.model.Users;
import com.cts.repository.PostRepository;
import com.cts.repository.UserRepository;

@RestController
public class PostController {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PostRepository postRepository;

	@GetMapping("/Users/{id}/posts")
	public List<Post> getByIdposts(@PathVariable int id) {
		List<Post> posts = repository.findById(id).get().getPosts();
		return posts;
	}

	@PostMapping("/Users/{id}/posts")
	public Post saveUserPosts(@PathVariable int id, @Valid @RequestBody Post post) {
		Users user = repository.findById(id).get();
		post.setUsers(user);
		Post savedPost = postRepository.save(post);
		return savedPost;
	}

	@GetMapping("/Users/{id}/posts/{id2}")
	public Post getUserPosts(@PathVariable int id, @PathVariable int id2) {
		List<Post> posts = repository.findById(id).get().getPosts();
		for (Post post : posts) {
			if (post.getId() == id2) {
				return postRepository.findById(id2).get();
			}
		}
		return null;

	}

	@DeleteMapping("/Users/{id}/posts/{id2}")
	public void deleteUserPosts(@PathVariable int id, @PathVariable int id2) {
		List<Post> posts = repository.findById(id).get().getPosts();
		for (Post post : posts) {
			if (post.getId() == id2) {
				postRepository.deleteById(id2);
			}
		}

	}

}
