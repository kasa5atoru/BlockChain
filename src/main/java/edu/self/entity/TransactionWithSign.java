package edu.self.entity;

import java.security.GeneralSecurityException;

import edu.self.util.Sign;
import io.swagger.v3.oas.annotations.media.Schema;

public class TransactionWithSign extends TransactionNoSign{

	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private byte[] signature;
	
	public TransactionWithSign(Person sender, Person receiver, long amount) {
		super(sender, receiver, amount);
		try {
			this.signature = Sign.sign(super.toString(), this.getSender().getPrivate_key());
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
