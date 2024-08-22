package edu.self.entity;

import java.util.ArrayList;

import lombok.ToString;

@ToString
public class TransactionPool {

	static ArrayList<Transaction> transactions;
	
	static{
		transactions = new ArrayList<Transaction>();
		transactions.add(new Transaction("alice", "bob", 250, "abc"));
	}
	
	public static void addTransaction(Transaction trans) {
		transactions.add(trans);
	}
	
	public static ArrayList<Transaction> get() {
		return transactions;
	}
}
