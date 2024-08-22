package edu.self.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Person {
	@NonNull
	private String name;
	
	@NonNull
	private String public_key;
	
	@NonNull
	private String private_key;
	
}
