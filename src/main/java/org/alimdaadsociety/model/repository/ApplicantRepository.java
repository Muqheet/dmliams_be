package org.alimdaadsociety.model.repository;

import org.alimdaadsociety.model.bean.Applicant;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
	
	Applicant findByAadhaar(Long aadhaar);
}
