package edu.self.entity;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.self.util.Sign;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

@ToString(exclude = {"publicKey", "privateKey"})
@Getter
public class Person {

	public Person() {
		try {
			KeyPair kp = 	Sign.generateKey();
			this.publicKey = kp.getPublic();
			this.privateKey = kp.getPrivate();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Person(String name) {
		this.name = name;
		try {
			KeyPair kp = 	Sign.generateKey();
			this.publicKey = kp.getPublic();
			this.privateKey = kp.getPrivate();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String name;
	
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	@JsonIgnore
	private PublicKey publicKey;
	
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	@JsonIgnore
	private PrivateKey privateKey;
	
	public void setName(String name) {
		this.name = name;
	}
}
