package org.alimdaadsociety.model.service;

import java.util.ArrayList;
import java.util.List;

import org.alimdaadsociety.model.bean.Applicant;
import org.alimdaadsociety.model.bean.EducationApplication;
import org.alimdaadsociety.model.repository.ApplicantRepository;
import org.alimdaadsociety.model.repository.EducationApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationApplicationService {
	
	@Autowired
	private EducationApplicationRepository educationApplicationRepository;
	@Autowired
	private ApplicantService applicantService;
	@Autowired
	private ApplicantRepository applicantRepository;
	
	public List<EducationApplication> getAll() {
		List<EducationApplication> educationApplications=new ArrayList<EducationApplication>();
		educationApplicationRepository.findAll().forEach(educationApplications::add);
		return educationApplications;
	}
	
	public EducationApplication get(Long id) {
		return educationApplicationRepository.findOne(id);
	}
	
	public Long add(EducationApplication educationApplication) {
		/*
		Find whether applicant exist or not by aadhaar_id
		If applicant exist get id, update it, and associate it with education application
		If applicant doesn't exist save it, get id, and associate it with education application
		Now save education application
		*/
		if(educationApplication.getApplicant() == null)
			throw new NullPointerException("Applicant is null");
		/*Applicant a = applicantRepository.save(educationApplication.getApplicant());
		educationApplication.setApplicant(a);*/
		return educationApplicationRepository.save(educationApplication).getApplicationid();
	}
	public void update(EducationApplication educationApplication) {
		/*if(educationApplication.getApplicationid() == null)
			throw new EntityNotFoundException("Applicationid is null or ");

		if(educationApplication.getApplicant().getAadhaar() == null)
			throw new EntityNotFoundException("Aadhaar is null");*/

			
		Applicant applicant = applicantRepository.save(educationApplication.getApplicant());
		educationApplication.setApplicant(applicant);
		educationApplicationRepository.save(educationApplication);
		applicantRepository.save(applicant);
	}
	
	public void delete(Long id) {
		educationApplicationRepository.delete(id);
	}

}
