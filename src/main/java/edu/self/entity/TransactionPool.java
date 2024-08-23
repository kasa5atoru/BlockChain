package edu.self.entity;

import java.util.ArrayList;

public class TransactionPool {

	static ArrayList<TransactionNoSign> transactions;
	
	static{
		transactions = new ArrayList<TransactionNoSign>();
		Person ps = new Person("alice");
		Person pr = new Person("bob");
		transactions.add(new TransactionNoSign(ps, pr, 250));
	}
	
	public static void addTransaction(TransactionNoSign trans) {
		transactions.add(trans);
	}
	
	public static ArrayList<TransactionNoSign> get() {
		return transactions;
	}
}
