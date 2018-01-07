package com.alimdaad.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.alimdaad.model.bean.Application;
import com.alimdaad.model.bean.MarriageApplication;
import com.alimdaad.model.bean.TreatmentApplication;

public interface TreatmentApplicationRepository extends CrudRepository<TreatmentApplication, Long> {

	
}
