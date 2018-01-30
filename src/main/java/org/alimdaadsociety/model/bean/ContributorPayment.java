package org.alimdaadsociety.model.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ContributorPayment
{

	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private long contributorpaymentid;
	
	@ManyToOne(cascade= {CascadeType.PERSIST})
	@JsonIgnore	//To don't send over REST request
	private Contributor contributor;
	
	private double payment_amount;
	
	@Temporal(TemporalType.DATE)
	private Date payment_date;
	
	private String payment_desc;//payment description, zakath/sadqa
	
	private String payment_mode;//cash/cheque/debit card/online bank transfer
	
	private long receipt_no;//to store paper-receipt number of contributor donations

//	******************* Getters & Setters *******************
	
	public long getContributorpaymentid() {
		return contributorpaymentid;
	}

	public void setContributorpaymentid(long contributorpaymentid) {
		this.contributorpaymentid = contributorpaymentid;
	}

	public Contributor getContributor() {
		return contributor;
	}

	public void setContributor(Contributor contributor) {
		this.contributor = contributor;
	}

	public double getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(double payment_amount) {
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

	public long getReceipt_no() {
		return receipt_no;
	}

	public void setReceipt_no(long receipt_no) {
		this.receipt_no = receipt_no;
	}
}
