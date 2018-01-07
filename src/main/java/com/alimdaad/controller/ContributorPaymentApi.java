package com.alimdaad.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alimdaad.model.bean.Contributor;
import com.alimdaad.model.bean.ContributorPayment;
import com.alimdaad.model.service.ContributorPaymentService;
import com.alimdaad.model.service.ContributorService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ContributorPaymentApi {
	
	@Autowired
	private ContributorPaymentService contributorPaymentService;
	@Autowired
	private ContributorService contributorService;
	
//	Get All By Contributor ID
	@RequestMapping(value="/ContributorPayments/{idContributor}", method=RequestMethod.GET)
	public List<ContributorPayment> getAllById(@PathVariable("idContributor") Long idContributor)
	{
		return contributorPaymentService.getAllPaymentsByContributorId(idContributor);
	}
	
	
//	Get By ContributorPayment ID
	@RequestMapping(value="/ContributorPayment/{idContributorPayment}", method=RequestMethod.GET)
	public ContributorPayment getOneById(@PathVariable("idContributorPayment") Long idContributorPayment)
	{
		return contributorPaymentService.get(idContributorPayment);
	}

		
//	Add
	@RequestMapping(value="/ContributorPayment/{idContributor}", method=RequestMethod.POST)
	public Long addPaymentToContributor(@RequestBody ContributorPayment contributorPayment,
			@PathVariable("idContributor") Long idContributor)
	{
		Contributor c= contributorService.get(idContributor);
		contributorPayment.setContributor(c);
		return contributorPaymentService.add(contributorPayment);
		
	}
	
		
//	Update
	@RequestMapping(value="/ContributorPayment/{idContributor}", method=RequestMethod.PUT)
	public void updatePaymentofContributor(@RequestBody ContributorPayment contributorPayment, @PathVariable("idContributor") Long idContributor)
	{
		if(contributorPaymentService.get(contributorPayment.getContributorpaymentid()) == null ||
				contributorService.get(idContributor) == null) 
		{
			throw new EntityNotFoundException("Either id is null, or no record exist with the given id to update");
		}
		else 
		{
			Contributor c= contributorService.get(idContributor);
			contributorPayment.setContributor(c);
			contributorPaymentService.update(contributorPayment);
		}
	}
	
	
//	Delete
	@RequestMapping(value="/ContributorPayment/{idContributorPayment}", method=RequestMethod.DELETE)
	public void deletePaymentFromContributor( @PathVariable("idContributorPayment")Long idContributorPayment )
	{
		contributorPaymentService.delete(idContributorPayment);
	}

	
//	ALL PAYMENTS
	@RequestMapping(value="/ContributorPayments", method=RequestMethod.GET)
	public List<ContributorPayment> getAll()
	{	
		return contributorPaymentService.getAll();
	}
/*	
	@RequestMapping(value="/Contributor", method=RequestMethod.POST)
	public void add(@RequestBody Contributor contributor)
	{
		contributorService.addOrUpdate(contributor);
	}
	
	@RequestMapping(value="/Contributor", method=RequestMethod.PUT)
	public void updateById(@RequestBody Contributor contributor)
	{
		contributorService.addOrUpdate(contributor);
	}
	
	@RequestMapping(value="/Contributors/{id}", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable("id") Long id)
	{
		contributorService.delete(id);
	}
*/
}
