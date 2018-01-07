package com.alimdaad.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alimdaad.model.bean.Applicant;
import com.alimdaad.model.repository.ApplicantRepository;

@Service
public class ApplicantService {
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	public List<Applicant> getAll() {
		List<Applicant> applicant=new ArrayList<Applicant>();
		applicantRepository.findAll().forEach(applicant::add);
		return applicant;
	}
	
	public Applicant get(Long id) {
		return applicantRepository.findOne(id);
	}
	
	public Long add(Applicant applicant) {
		return applicantRepository.save(applicant).getApplicantid();	
	}

	public void update(Applicant applicant) {
		if((applicantRepository.findOne(applicant.getApplicantid())) != null)
			applicantRepository.save(applicant);		
	}
	
	public void delete(Long id) {
		applicantRepository.delete(id);
	}

	public Applicant findByAadhaar(Long aadhaar_id) {
		return applicantRepository.findByAadhaar(aadhaar_id);
	}
}
