package edu.self.service;

import java.util.List;

import edu.self.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	
	Customer saveCustomer(Customer student);
	
	Customer getCustomerById(Long id);
	
	Customer updateCustomer(Customer student);
	
	void deleteCustomerById(Long id);
}
