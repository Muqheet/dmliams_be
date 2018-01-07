package com.alimdaad.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alimdaad.model.bean.ContributorPayment;

@Repository
public interface ContributorPaymentRepository extends CrudRepository<ContributorPayment, Long> {

	List<ContributorPayment> findByContributorContributorid(Long id);
	
}
