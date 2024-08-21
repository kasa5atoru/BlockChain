package edu.self.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.self.entity.Customer;
import edu.self.repository.CustomerRepository;
import edu.self.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return this.customerRepository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(Long id) {
		return this.customerRepository.findById(id).get();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerById(Long id) {
		 this.customerRepository.deleteById(id);
	}

}
