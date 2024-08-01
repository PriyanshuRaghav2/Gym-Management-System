package com.sppm.GymManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sppm.GymManagementSystem.bean.GymUser;
import com.sppm.GymManagementSystem.dao.GymUserRepository;

@Service
public class GymUserService implements UserDetailsService {
	@Autowired
	private GymUserRepository repository;
	private String type;
	private GymUser users;
	public void save(GymUser user) {
		repository.save(user);
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		users= repository.findById(username).get();
		type=users.getType();
		return users;
	}
	
	public List<GymUser> getAllCustomer(){
		return repository.findAllCoustomerUsers();
	}
	
	public GymUser getUser() {
		return users;
	}

	public void deleteUserById(String username) {
		
		repository.delete(users);
		
	}
}
