package com.alimdaad.model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="applicationid")
@Table(name="TreatmentApplication")

public class TreatmentApplication extends Application 
{
	@OneToOne(cascade=CascadeType.ALL)
	private ApplicationPayment applicationPayment;
	
	@ManyToOne
	Applicant applicant;
		
	private String disease_name;
	
	private String period_of_disease;
	
	private String admitted_hospital_name;

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

	public String getDisease_name() {
		return disease_name;
	}

	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}

	public String getPeriod_of_disease() {
		return period_of_disease;
	}

	public void setPeriod_of_disease(String period_of_disease) {
		this.period_of_disease = period_of_disease;
	}

	public String getAdmitted_hospital_name() {
		return admitted_hospital_name;
	}

	public void setAdmitted_hospital_name(String admitted_hospital_name) {
		this.admitted_hospital_name = admitted_hospital_name;
	}	
	
}
