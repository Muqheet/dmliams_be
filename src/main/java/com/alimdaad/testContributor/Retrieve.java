package com.alimdaad.testContributor;

import org.springframework.beans.factory.annotation.Autowired;

import com.alimdaad.model.bean.Contributor;
import com.alimdaad.model.service.ContributorService;

public class Retrieve {

	@Autowired
	ContributorService contributorService;
	public String getEmail(Long id)
	{		
		return contributorService.get(1l).getEmail();
	}
	
	public static void main(String[] args) 
	{

//		ContributorService contributorService = new ContributorService();
		
		Retrieve r=new Retrieve();
		System.out.println(r.getEmail(1l));
	}

}
