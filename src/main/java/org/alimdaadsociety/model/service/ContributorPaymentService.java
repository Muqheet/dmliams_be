package org.alimdaadsociety.model.service;

import java.util.ArrayList;
import java.util.List;

import org.alimdaadsociety.model.bean.ContributorPayment;
import org.alimdaadsociety.model.repository.ContributorPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ContributorPaymentService {

	@Autowired
	private ContributorPaymentRepository contributorPaymentRepository;
	
	public List<ContributorPayment> getAll() {
		
		List<ContributorPayment> contributorPayments=new ArrayList<ContributorPayment>();
		contributorPaymentRepository.findAll().forEach(contributorPayments::add);
		return contributorPayments;
	}
	
	public List<ContributorPayment> getAllPaymentsByContributorId(Long idContributor) {
		
		List<ContributorPayment> contributorPayments=new ArrayList<ContributorPayment>();		
		contributorPaymentRepository.findByContributorContributorid(idContributor)
									.forEach(contributorPayments::add);
		return contributorPayments;
	}
	
	public ContributorPayment get(Long id) {
		return contributorPaymentRepository.findOne(id);
	}
	
	public Long add(ContributorPayment contributorPayment) {
		return contributorPaymentRepository.save(contributorPayment).getContributorpaymentid();
	}
	
	public void update(ContributorPayment contributorPayment) {
		contributorPaymentRepository.save(contributorPayment);
	}
	
	public void delete(Long id) {
		contributorPaymentRepository.delete(id);
	}
}
