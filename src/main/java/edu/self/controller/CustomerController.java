package edu.self.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.self.entity.Customer;
import edu.self.service.CustomerService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class CustomerController  {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public String toppage(Model model) {
		log.debug("toppage");
		return "redirect:/login";
	}
	
	@GetMapping("/customers")
	public String listCustomers(Model model) {
		log.debug("listCustomers");

		model.addAttribute("customers", customerService.getAllCustomers());

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //Principalからログインユーザの情報を取得
        model.addAttribute("userName", auth.getName());

        return "customers";
	}
	
	@GetMapping("/customers/new")
	public String createCustomerForm(Model model) {
		log.debug("createCustomerForm");
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "create_customer";
	}
	
	@PostMapping("/customers")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		customer.setInsertDate(new Date());
		customer.setInsertName(auth.getName());
		customer.setUpdateDate(new Date());
		customer.setUpdateName(auth.getName());
		
		log.debug("saveCustomer : "+customer);
		customerService.saveCustomer(customer);
		return "redirect:/customers";
	}
	
	@GetMapping("/customers/edit/{id}")
	public String editCustomerForm(@PathVariable Long id, Model model) {
		log.debug("editCustomerForm");
		model.addAttribute("customer", customerService.getCustomerById(id));
		return "edit_customer";
	}
	
	@PostMapping("/customers/{id}")
	public String updateCustomer(@PathVariable Long id,
			@ModelAttribute("customer") Customer customer,
			Model model) {

		// get customer from database by id
		Customer existingCustomer = customerService.getCustomerById(id);
		existingCustomer.setId(id);
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setEmail(customer.getEmail());
		
		existingCustomer.setUpdateDate(new Date());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //Principalからログインユーザの情報を取得
		existingCustomer.setUpdateName(auth.getName());
		// save updated customer object
		customerService.updateCustomer(existingCustomer);

		log.debug("updateCustomer : " + existingCustomer);
		
		return "redirect:/customers";		
	}
	
	@GetMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		log.debug("deleteCustomer");
		customerService.deleteCustomerById(id);
		return "redirect:/customers";
	}
}
