package org.alimdaadsociety.model.repository;

import java.util.List;

import org.alimdaadsociety.model.bean.ContributorPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributorPaymentRepository extends CrudRepository<ContributorPayment, Long> {

	List<ContributorPayment> findByContributorContributorid(Long id);
	
}
