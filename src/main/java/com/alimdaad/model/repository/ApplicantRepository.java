package com.alimdaad.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.alimdaad.model.bean.Applicant;

public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
	
	Applicant findByAadhaar(Long aadhaar);
}
