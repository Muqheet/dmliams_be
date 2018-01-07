package com.alimdaad.model.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ApplicationPayment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long applicationpaymentid;
	
	/*@ManyToOne(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="idApplication", insertable=false, updatable=false)
	private PensionApplication pensionApplication;*/
	
	private Double payment_amount;
	
	@Temporal(TemporalType.DATE)
	private Date payment_date;
	
//	payment description, zakath/sadqa etc
	private String payment_desc;
	
//	cash/cheque/debit card/online bank transfer
	private String payment_mode;
	
//	Monthly pension/treatment/education etc
	private String payment_category;
	
//	******************* Getters & Setters *******************
	
	public Long getApplicationpaymentid() {
		return applicationpaymentid;
	}

	public void setApplicationpaymentid(Long applicationpaymentid) {
		this.applicationpaymentid = applicationpaymentid;
	}

	/*public PensionApplication getPensionApplication() {
		return pensionApplication;
	}

	public void setPensionApplication(PensionApplication pensionApplication) {
		this.pensionApplication = pensionApplication;
	}*/

	public Double getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(Double payment_amount) {
		this.payment_amount = payment_amount;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public String getPayment_desc() {
		return payment_desc;
	}

	public void setPayment_desc(String payment_desc) {
		this.payment_desc = payment_desc;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public String getPayment_category() {
		return payment_category;
	}

	public void setPayment_category(String payment_category) {
		this.payment_category = payment_category;
	}		
}
