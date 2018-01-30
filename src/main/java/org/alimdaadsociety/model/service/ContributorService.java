package org.alimdaadsociety.model.service;

import java.util.ArrayList;
import java.util.List;

import org.alimdaadsociety.model.bean.Contributor;
import org.alimdaadsociety.model.repository.ContributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContributorService {
	
	@Autowired
	private ContributorRepository contributorRepository;
	
	public List<Contributor> getAll() {
		List<Contributor> contributors=new ArrayList<Contributor>();
		contributorRepository.findAll().forEach(contributors::add);
		return contributors;
	}
	
	public Contributor get(Long id) {
		return contributorRepository.findOne(id);
	}
	
	public Contributor add(Contributor contributor) {
		return contributorRepository.save(contributor);
	}	
	
	public void update(Contributor contributor) {
		contributorRepository.save(contributor);	
	}
	
	public void delete(Long id) {
		contributorRepository.delete(id);
	}

	public Contributor getByMobile(String mobile) {
		return contributorRepository.findByMobile(mobile);
	}

	public Contributor getByEmail(String email) {
		return contributorRepository.findByEmail(email);
	}

}
