package org.alimdaadsociety.model.repository;

import java.util.List;

import org.alimdaadsociety.model.bean.AppUserRoles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRolesRepository extends CrudRepository<AppUserRoles, Long>
{
	
	/*@Query("select a.role from AppUserRoles a, User b where b.userName=?1 and a.idUser=b.idUser")
	public List<String> findRoleByUserName(String userName);*/
		
}
