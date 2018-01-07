package com.alimdaad.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alimdaad.model.bean.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long>
{	
	public Users findByEmail(String email);
}