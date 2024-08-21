package edu.self;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.self.entity.Customer;
import edu.self.entity.User;
import edu.self.repository.CustomerRepository;
import edu.self.repository.UserRepository;

@SpringBootApplication
public class BlockChainApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BlockChainApplication.class, args);
	}

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		String name = "startup";
		Date now = new Date();
		
		Customer c1 = new Customer("Ramesh", "Fadatare", "ramesh@gmail.com", now, name, now, name);
		 customerRepository.save(c1);
		 
		 Customer c2 = new Customer("Sanjay", "Jadhav", "sanjay@gmail.com", now, name, now, name);
		 customerRepository.save(c2);
		 
		 Customer c3 = new Customer("tony", "stark", "tony@gmail.com", now, name, now, name);
		 customerRepository.save(c3);
		 
		User u1 = new User();
		u1.setUserName("kasa5atoru");
		u1.setPassword("ookuma33");
		u1.setActive(true);
		u1.setRoles("Admin");
		userRepository.save(u1);
	 
		User u2 = new User();
		u2.setUserName("abc");
		u2.setPassword("123");
		u2.setActive(true);
		u2.setRoles("Admin");
		userRepository.save(u2);
	}

}
