package com.pollra.pudding.domain.account.service.command;

import lombok.*;

/**
 * @since       2021.04.15
 * @author      pollra
 * @description AccountCommand
 **********************************************************************************************************************/
public class AccountCommand {
	
	public static class Request {
		@Getter
		@Setter
		@NoArgsConstructor
		@AllArgsConstructor
		public static class Create {
			private String identity;
			private String nickname;
			private String password;
			private String passwordCheck;
		}
	}
	
	public static class Response {
		@Getter
		@Setter
		@NoArgsConstructor
		@AllArgsConstructor
		public static class Create {
			private Long id;
			private String identity;
			private String nickname;
		}
	}
}
