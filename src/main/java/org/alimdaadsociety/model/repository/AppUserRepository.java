package org.alimdaadsociety.model.repository;

import org.alimdaadsociety.model.bean.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long>
{	
	public AppUser findByEmail(String email);
}