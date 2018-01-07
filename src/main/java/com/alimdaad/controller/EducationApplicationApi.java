package com.alimdaad.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alimdaad.model.bean.Applicant;
import com.alimdaad.model.bean.EducationApplication;
import com.alimdaad.model.service.ApplicantService;
import com.alimdaad.model.service.EducationApplicationService;

@RestController
@RequestMapping("/api")
public class EducationApplicationApi {

	@Autowired
	private EducationApplicationService educationApplicationService;
	@Autowired
	private ApplicantService applicantService;
	
	
//	Get All
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/EducationApplications", method=RequestMethod.GET)
	public List<EducationApplication> getAll()
	{	
		return educationApplicationService.getAll();
	}
	
	
//	Get By ID
	@RequestMapping(value="/EducationApplication/{id}", method=RequestMethod.GET)
	public EducationApplication getById(@PathVariable("id") Long id)
	{
		return educationApplicationService.get(id);
	}
	
	
	
//	Add
	@RequestMapping(value="/EducationApplication", method=RequestMethod.POST)
	public Long add(@RequestBody EducationApplication educationApplication)
	{
		
		/*Long aadhaar_id = educationApplication.getApplicant().getAadhaar();
		Applicant applicant = applicantService.findByAadhaar(aadhaar_id);*/		
		return educationApplicationService.add(educationApplication);
	}
	
	
	
//	Update
	@RequestMapping(value="/EducationApplication", method=RequestMethod.PUT)
	public void updateById(@RequestBody EducationApplication educationApplication)
	{
		educationApplicationService.update(educationApplication);
	}
	
	
	
//	Delete
	@RequestMapping(value="/EducationApplication/{id}", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable("id") Long id)
	{
		educationApplicationService.delete(id);
	}
	
}
