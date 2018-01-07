package com.alimdaad.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alimdaad.model.bean.Contributor;

@Repository
public interface ContributorRepository extends CrudRepository<Contributor, Long> 
{
	Contributor findByMobile(String mobile);
	Contributor findByEmail(String email);
	/*@Query("select c from Contributor c "
			+ "where c.Contributor like ?1 "
			+ "order by ?2 ?3 limit ?4,?5")*/
	/*List<Contributor> findAllPaginated();*/
}