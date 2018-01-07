package com.alimdaad.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.alimdaad.model.bean.Application;
import com.alimdaad.model.bean.EducationApplication;
import com.alimdaad.model.bean.MarriageApplication;

public interface EducationApplicationRepository extends CrudRepository<EducationApplication, Long> {
	
}
