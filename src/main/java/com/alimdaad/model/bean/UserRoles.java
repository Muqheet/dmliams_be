package com.alimdaad.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRoles
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUserRole;
		
	private String role;

	public Long getIdUserRole() {
		return idUserRole;
	}

	public void setIdUserRole(Long idUserRole) {
		this.idUserRole = idUserRole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
