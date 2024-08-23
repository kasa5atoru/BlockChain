package edu.self.entity;

import java.security.GeneralSecurityException;

import edu.self.util.Sign;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransactionWithSign extends TransactionNoSign{

	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private byte[] signature;
	
	public TransactionWithSign(Person sender, Person receiver, long amount) {
		super(sender, receiver, amount);
		
		if(this.signature == null) {
			try {
				log.debug("Signing use key of Sender:"+sender.getName());
				this.signature = Sign.sign(super.toString(), this.getSender().getPrivateKey());
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
	
	public byte[] getSignature() {
		return signature;
	}
}
