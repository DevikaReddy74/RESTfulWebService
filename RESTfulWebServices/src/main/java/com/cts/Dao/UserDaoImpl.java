/*
 * UserDaoImpl Without JPA
package com.cts.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cts.model.Users;

//To be managed by spring
@Component
public class UserDaoImpl {

	private static List<Users> users=new ArrayList<>();
	
	static {
		users.add(new Users(1, "Dev", new Date()));
		users.add(new Users(2, "Devika", new Date()));
		
	}
	public Users save(Users user) {
		users.add(user);
		return user;
		
	}
	public List<Users> findAll(){
		return users;
	}
	public Users findById(int id) {
		for (Users user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
}
 */
