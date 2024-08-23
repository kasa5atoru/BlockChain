package edu.self.entity;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.self.util.Sign;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString(exclude = {"public_key", "private_key"})
public class Person {
	public Person(String name) {
		this.name = name;
		try {
			KeyPair kp = 	Sign.generateKey();
			this.public_key = kp.getPublic();
			this.private_key = kp.getPrivate();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@NonNull
	private String name;
	
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	@JsonIgnore
	private PublicKey public_key;
	
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	@JsonIgnore
	private PrivateKey private_key;
	
}
