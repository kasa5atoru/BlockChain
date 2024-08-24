package edu.self.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

	// 処理結果コード
	private String resultCode;

	// 処理結果メッセージ
	private String message;
}
