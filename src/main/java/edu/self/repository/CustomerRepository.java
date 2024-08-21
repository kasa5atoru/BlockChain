package edu.self.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.self.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
