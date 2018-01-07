package com.alimdaad.model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//@DiscriminatorColumn(name="ApplicationType", discriminatorType=DiscriminatorType.STRING)  
//@DiscriminatorValue("EducationalAssistanceApplication")
@Table(name="EducationApplication")
@Entity
@PrimaryKeyJoinColumn(name="applicationid")

public class EducationApplication extends Application
{
	@NotNull
	@OneToOne(cascade=CascadeType.ALL)
	private ApplicationPayment applicationPayment;
	
	@NotNull
	@ManyToOne(cascade=CascadeType.PERSIST)
	Applicant applicant = new Applicant();
	
//	******************* Getters & Setters *******************

	public ApplicationPayment getApplicationPayment() {
		return applicationPayment;
	}

	public void setApplicationPayment(ApplicationPayment applicationPayment) {
		this.applicationPayment = applicationPayment;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
		
}
