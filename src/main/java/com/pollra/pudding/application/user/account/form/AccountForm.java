package com.pollra.pudding.application.user.account.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @since       2021.04.15
 * @author      pollra
 * @description AccountForm
 **********************************************************************************************************************/
public class AccountForm {
	
	public static class Request {
		@Data
		@NoArgsConstructor
		@AllArgsConstructor
		public static class Create{
			@NotBlank
			private String identity;
			
			@NotBlank
			private String nickname;
			
			@NotBlank
			private String password;
			
			@NotBlank
			private String passwordCheck;
		}
	}
	
	public static class Response {
		@Data
		public static class FineOne {
			private String id;
			private String identity;
			private String nickname;
		}
	}
}
