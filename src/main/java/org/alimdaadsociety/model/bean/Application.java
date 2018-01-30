package org.alimdaadsociety.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy=InheritanceType.JOINED)
@Entity
public class Application
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long applicationid;
/*	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<String> documents_for_proof=new HashSet<String>(0);
*/	
//	******************* Getters & Setters *******************

	public Long getApplicationid() {
		return applicationid;
	}

	public void setApplicationid(Long applicationid) {
		this.applicationid = applicationid;
	}
/*
	public Set<String> getDocuments_for_proof() {
		return documents_for_proof;
	}

	public void setDocuments_for_proof(Set<String> documents_for_proof) {
		this.documents_for_proof = documents_for_proof;
	}
*/	
}
