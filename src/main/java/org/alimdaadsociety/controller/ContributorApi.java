package org.alimdaadsociety.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.alimdaadsociety.model.bean.Contributor;
import org.alimdaadsociety.model.service.ContributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
//@CrossOrigin("*")
public class ContributorApi {
/*	
	private ContributorDao dao;
	
	@Autowired
	public void setContributorDao(ContributorDao dao) {
		this.dao=dao;
	}
*/	
	@Autowired
	private ContributorService contributorService;
	
	
//	Get All
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/Contributors", method=RequestMethod.GET)
	public List<Contributor> getAll()
	{	
		return contributorService.getAll();
	}
//	Get All Paginated	
	@RequestMapping(value="/ContributorsPaginated", method=RequestMethod.POST)
	public List<Contributor> getAllPaginated()
	{	
		return contributorService.getAll();
	}
	
	
//	Get By ID
	@RequestMapping(value="/Contributor/{id}", method=RequestMethod.GET)
	public Contributor getById(@PathVariable("id") Long id)
	{
		return contributorService.get(id);
	}
	
	
	
//	Add
	@RequestMapping(value="/Contributor", method=RequestMethod.POST)
	public Long add(@RequestBody Contributor contributor)
	{
		Contributor c = contributorService.add(contributor);
		 return c.getContributorid();
	}
	
	
	
//	Update
	@RequestMapping(value="/Contributor", method=RequestMethod.PUT)
	public void updateById(@RequestBody Contributor contributor)
	{
		if(contributorService.get(contributor.getContributorid()) != null) {
			contributorService.update(contributor);
		}
		else {
			throw new EntityNotFoundException("Either id is null, or no record exist with the given id to update");
		}
	}
	
	
//	Delete
	@RequestMapping(value="/Contributor/{id}", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable("id") Long id)
	{
		contributorService.delete(id);
	}
	
//	Get By Mobile
	@RequestMapping(value="/Contributor/mobile", method=RequestMethod.POST)
	public Contributor getByMobile(@RequestParam String mobile)
	{
		return contributorService.getByMobile(mobile);
	}
	
//	Get By Email
	@RequestMapping(value="/Contributor/email", method=RequestMethod.POST)
	public Contributor getByEmail(@RequestParam String email)
	{
		return contributorService.getByEmail(email);
	}
	
}
