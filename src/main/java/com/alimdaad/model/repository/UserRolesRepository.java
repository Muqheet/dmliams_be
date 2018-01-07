package com.alimdaad.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.alimdaad.model.bean.UserRoles;

public interface UserRolesRepository extends CrudRepository<UserRoles, Long>
{
	
	/*@Query("select a.role from UserRoles a, User b where b.userName=?1 and a.idUser=b.idUser")
	public List<String> findRoleByUserName(String userName);*/
		
}
