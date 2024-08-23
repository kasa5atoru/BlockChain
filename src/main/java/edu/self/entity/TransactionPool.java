package edu.self.entity;

import java.security.GeneralSecurityException;
import java.util.ArrayList;

import edu.self.util.Sign;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransactionPool {

	static ArrayList<TransactionWithSign> transactions;
	
	static{
		transactions = new ArrayList<TransactionWithSign>();
		Person ps = new Person("alice");
		Person pr = new Person("bob");
		addTransaction(new TransactionNoSign(ps, pr, 250));
	}
	
	public static boolean addTransaction(TransactionNoSign trans) {
		TransactionWithSign tranSign = new TransactionWithSign(trans.getSender(), trans.getReceiver(), trans.getAmount());
		
		// 送金金額がマイナスの送金は異常である
		if(trans.getAmount() < 0) {
			return false;
		}
		
		// 署名確認できない送金は異常である。
		boolean signRes = false;
		try {
			signRes = Sign.verify(trans.toString(), tranSign.getSignature(), trans.getSender().getPublicKey());
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		if(!signRes) {
			log.debug("トランザクション署名検証失敗！");
			return false;
		}
		
		transactions.add(tranSign);
		return true;
	}
	
	public static ArrayList<TransactionWithSign> get() {
		return transactions;
	}
}
