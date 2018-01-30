package org.alimdaadsociety.model.repository;

import org.alimdaadsociety.model.bean.Application;
import org.alimdaadsociety.model.bean.EducationApplication;
import org.alimdaadsociety.model.bean.MarriageApplication;
import org.springframework.data.repository.CrudRepository;

public interface EducationApplicationRepository extends CrudRepository<EducationApplication, Long> {
	
}
