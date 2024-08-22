package edu.self.entity;

import java.util.ArrayList;

public class TransactionPool {

	static ArrayList<Transaction> transactions;
	
	static{
		transactions = new ArrayList<Transaction>();
		Person ps = new Person("alice", "public", "private");
		Person pr = new Person("bob", "public", "private");
		transactions.add(new Transaction(ps, pr, 250, "abc"));
	}
	
	public static void addTransaction(Transaction trans) {
		transactions.add(trans);
	}
	
	public static ArrayList<Transaction> get() {
		return transactions;
	}
}
