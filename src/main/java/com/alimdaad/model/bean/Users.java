package com.alimdaad.model.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUser;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<UserRoles> userRoles;
	
	private String userName;
	
	private String email;
	
	private String passsword;
	
	private byte enabledState;
	
	
	public Users() {
		super();
	}
//	For Spring Security
	public Users(Users users) {
		this.idUser = users.getIdUser();
		this.userName = users.getUserName();
		this.email = users.getEmail();
		this.passsword = users.getPasssword();
		this.enabledState = users.getEnabledState();
		this.userRoles = users.getUserRoles();
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Set<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public byte getEnabledState() {
		return enabledState;
	}

	public void setEnabledState(byte enabledState) {
		this.enabledState = enabledState;
	}

}
