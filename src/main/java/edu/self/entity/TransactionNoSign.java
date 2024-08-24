package edu.self.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TransactionNoSign {

	// Time of Transaction
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime time = LocalDateTime.now();
	
	@NonNull
	private Person sender;
	
	@NonNull
	private Person receiver;
	
	@NonNull
	private long amount;
}
