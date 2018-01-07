package com.alimdaad.model.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@PrimaryKeyJoinColumn(name="applicationid")
@Table(name="MarriageApplication")

public class MarriageApplication extends Application
{
	@OneToOne(cascade=CascadeType.ALL)
	private ApplicationPayment applicationPayment;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="applicant_applicantid", unique=true)	//unique because One Applicant should contain only one MarriageApplication.
	Applicant applicant;
	
	private String place_of_marriage;
	
	@Temporal(TemporalType.DATE)
	private Date date_of_marriage;
	
	private String name_of_bridegroom;
	
	private String occupation_of_bridegroom;

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

	public String getPlace_of_marriage() {
		return place_of_marriage;
	}

	public void setPlace_of_marriage(String place_of_marriage) {
		this.place_of_marriage = place_of_marriage;
	}

	public Date getDate_of_marriage() {
		return date_of_marriage;
	}

	public void setDate_of_marriage(Date date_of_marriage) {
		this.date_of_marriage = date_of_marriage;
	}

	public String getName_of_bridegroom() {
		return name_of_bridegroom;
	}

	public void setName_of_bridegroom(String name_of_bridegroom) {
		this.name_of_bridegroom = name_of_bridegroom;
	}

	public String getOccupation_of_bridegroom() {
		return occupation_of_bridegroom;
	}

	public void setOccupation_of_bridegroom(String occupation_of_bridegroom) {
		this.occupation_of_bridegroom = occupation_of_bridegroom;
	}

}
