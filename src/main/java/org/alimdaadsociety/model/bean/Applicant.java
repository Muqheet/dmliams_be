package org.alimdaadsociety.model.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Applicant
{	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long applicantid;
	
///*When Applicant obj is removed it should remove all it associated Applications, Therefore, CascadeType.REMOVE
	@JsonIgnore
	@OneToMany(mappedBy="applicant", cascade=CascadeType.REMOVE)
	Set<EducationApplication> educationApplications=new HashSet<EducationApplication>(0);
	
	@JsonIgnore
	@OneToMany(mappedBy="applicant", cascade=CascadeType.REMOVE)
	Set<TreatmentApplication> treatmentApplications=new HashSet<TreatmentApplication>(0);
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.REMOVE, mappedBy="applicant")
	PensionApplication pensionApplication;
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.REMOVE, mappedBy="applicant")
	MarriageApplication marriageApplication;
//*/
	private Long aadhaar;
	
	private String name;
	
	private String mobile;
	
	private String email;
	
	private String gender;

	private String e_qualification;
		
	private String state;
	
	private String city;
	
	private String street_addr;
	
	private String house_no;
	
	private String zipcode;

	private String photo_name;
	
	@Temporal(TemporalType.DATE)
	private Date date_of_birth;
	
//	Family Details:
	private byte no_of_family_members;
	
	private byte no_of_sons;
	
	private byte no_of_daughters;
	
//	if married, husband_name else father name		
	private String father_or_husband_name;

	
	
	
	
	
	
	
	public Long getApplicantid() {
		return applicantid;
	}

	public void setApplicantid(Long applicantid) {
		this.applicantid = applicantid;
	}

	public Set<EducationApplication> getEducationApplications() {
		return educationApplications;
	}

	public void setEducationApplications(Set<EducationApplication> educationApplications) {
		this.educationApplications = educationApplications;
	}

	public Set<TreatmentApplication> getTreatmentApplications() {
		return treatmentApplications;
	}

	public void setTreatmentApplications(Set<TreatmentApplication> treatmentApplications) {
		this.treatmentApplications = treatmentApplications;
	}

	public PensionApplication getPensionApplication() {
		return pensionApplication;
	}

	public void setPensionApplication(PensionApplication pensionApplication) {
		this.pensionApplication = pensionApplication;
	}

	public MarriageApplication getMarriageApplication() {
		return marriageApplication;
	}

	public void setMarriageApplication(MarriageApplication marriageApplication) {
		this.marriageApplication = marriageApplication;
	}

	public Long getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(Long aadhaar) {
		this.aadhaar = aadhaar;
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

	public String getE_qualification() {
		return e_qualification;
	}

	public void setE_qualification(String e_qualification) {
		this.e_qualification = e_qualification;
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

	public String getStreet_addr() {
		return street_addr;
	}

	public void setStreet_addr(String street_addr) {
		this.street_addr = street_addr;
	}

	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhoto_name() {
		return photo_name;
	}

	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public byte getNo_of_family_members() {
		return no_of_family_members;
	}

	public void setNo_of_family_members(byte no_of_family_members) {
		this.no_of_family_members = no_of_family_members;
	}

	public byte getNo_of_sons() {
		return no_of_sons;
	}

	public void setNo_of_sons(byte no_of_sons) {
		this.no_of_sons = no_of_sons;
	}

	public byte getNo_of_daughters() {
		return no_of_daughters;
	}

	public void setNo_of_daughters(byte no_of_daughters) {
		this.no_of_daughters = no_of_daughters;
	}

	public String getFather_or_husband_name() {
		return father_or_husband_name;
	}

	public void setFather_or_husband_name(String father_or_husband_name) {
		this.father_or_husband_name = father_or_husband_name;
	}
	

	}