package com.concerto.loan.api.service;

import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concerto.loan.api.dao.CustomerRepository;
import com.concerto.loan.api.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public Customer findCustomerByEmail(String customerEmail) {
		Optional<Customer> optional = customerRepository.findById(customerEmail);
		return optional.orElseThrow(() -> new EntityNotFoundException("Customer is Not Found"));
	}
	
	public boolean addCustomer(Customer customer) {
		if (!customerRepository.existsById(customer.getCustomerEmailId())) {
			customerRepository.save(customer);
			return true;
		}
		throw new EntityExistsException("Customer already exist.");
	}
	

}
