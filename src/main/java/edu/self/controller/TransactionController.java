package edu.self.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.self.entity.Response;
import edu.self.entity.TransactionNoSign;
import edu.self.entity.TransactionPool;
import edu.self.entity.TransactionWithSign;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TransactionController {

	@GetMapping(value = "/transaction_pool")
	public ArrayList<TransactionWithSign> showPool() {
		ArrayList<TransactionWithSign> res =TransactionPool.get(); 
		res.iterator().forEachRemaining(i -> {
			log.debug(i.toString());
		});
		return res;
	}
	
	@PostMapping(value = "/transaction_pool")
	@ResponseBody
	public Response postTransactionPool(@RequestBody TransactionNoSign trans) {
		log.debug("Posted params as below: " + trans);
		if(TransactionPool.addTransaction(trans)) {		
			return Response.builder().resultCode("200").message("OK").build();
		}
		return Response.builder().resultCode("200").message("NG").build();
	}
}
