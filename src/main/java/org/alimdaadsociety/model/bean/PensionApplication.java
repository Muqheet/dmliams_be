package org.alimdaadsociety.model.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="applicationid")
@Table(name="PensionApplication")

public class PensionApplication extends Application
{	
	private Integer monthly_pension_card_id;
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY/*, mappedBy="pensionApplication"*/)
	private Set<ApplicationPayment> applicationPayments=new HashSet<ApplicationPayment>(0);
	
//	when PensionApplication obj is persisted, it should also persist the Applicant obj.
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="applicant_applicantid", unique=true)//to allow only one PensionApplication per Applicant, "unique=true" is written.
/*	@JoinTable(
			name="PensionApplication_has_Applicant",
			joinColumns=@JoinColumn(name="idPensionApplication"),
			inverseJoinColumns=@JoinColumn(name="idApplicant")
			)*/
	Applicant applicant;

//	******************* Getters & Setters *******************

	public Integer getMonthly_pension_card_id() {
		return monthly_pension_card_id;
	}

	public void setMonthly_pension_card_id(Integer monthly_pension_card_id) {
		this.monthly_pension_card_id = monthly_pension_card_id;
	}

	public Set<ApplicationPayment> getApplicationPayments() {
		return applicationPayments;
	}

	public void setApplicationPayments(Set<ApplicationPayment> applicationPayments) {
		this.applicationPayments = applicationPayments;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
}
