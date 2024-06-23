package com.sppm.GymManagementSystem.bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class GymUser extends User{
	
	@Id
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String type;
	
	public GymUser() {
		super("abc","xyz", new ArrayList<>());
	}
	
	public GymUser(String username, String password, Collection<? extends GrantedAuthority> authorities,String username2,String password2,String firstName, String lastName, String email, String type) {
		super(username, password, authorities);
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.type = type; 
		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	@Override
//	public String toString() {
//		return "GymUser [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
//				+ lastName + ", email=" + email + ", type=" + type + "]";
//	}
	
	
}
