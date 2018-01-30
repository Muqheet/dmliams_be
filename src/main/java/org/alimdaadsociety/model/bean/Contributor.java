package org.alimdaadsociety.model.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Entity
@JsonPropertyOrder({"contributorid", "name", "mobile", "email", "gender", "country", "state", "city", "street", "house_no", "zipcode"})
public class Contributor
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long contributorid;
	
//	if u specify "mappedBy" property then one more extra table for relationship is not created.
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="contributor")
	@JsonIgnore
/*	@JoinTable(
			name="Contributor_has_ContributorPayment",
			joinColumns=@JoinColumn(name="idContributor"),
			inverseJoinColumns=@JoinColumn(name="idContributorPayment")
			)
*/
	private Set<ContributorPayment> contributorPayments= new HashSet<ContributorPayment>(0);

//	@Size(min=3, max=30)
	private String name;
	
//	@Column(nullable=false, unique=true)
	private String mobile;
	
//	@Column(unique=true)
	private String email;
	
	private String gender;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String street;
	
	private String house_no;
	
	private Integer zipcode;
	
//	******************* Getters & Setters *******************

	public Long getContributorid() {
		return contributorid;
	}

	public void setContributorid(Long contributorid) {
		this.contributorid = contributorid;
	}

	public Set<ContributorPayment> getContributorPayments() {
		return contributorPayments;
	}

	public void setContributor_Payments(Set<ContributorPayment> contributorPayments) {
		this.contributorPayments = contributorPayments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

}
