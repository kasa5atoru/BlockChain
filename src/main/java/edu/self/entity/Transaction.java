package edu.self.entity;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Transaction {

	// Time of Transaction
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime time = LocalDateTime.now();
	
	@NonNull
	private String sender;
	
	@NonNull
	private String receiver;
	
	@NonNull
	private long amount;
	
	@NonNull
	private String signature;
}
