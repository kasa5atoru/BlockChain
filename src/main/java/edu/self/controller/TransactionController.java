package edu.self.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.self.entity.Transaction;
import edu.self.entity.TransactionPool;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TransactionController {

	@GetMapping(value = "/transaction_pool")
	public ArrayList<Transaction> showPool() {
		return TransactionPool.get();
	}
	@PostMapping(value = "/transaction_pool")
	public String greeting(@RequestBody Transaction trans) {
		log.debug("Posted params as below: " + trans);
		TransactionPool.addTransaction(trans);
		return "OK";
	}
}
