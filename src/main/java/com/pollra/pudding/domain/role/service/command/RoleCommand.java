package com.pollra.pudding.domain.role.service.command;

import com.pollra.pudding.domain.role.entity.AuthorityCode;
import lombok.Builder;
import lombok.Data;

/**
 * @since       2021.04.15
 * @author      pollra
 * @description RoleCommand
 **********************************************************************************************************************/
public class RoleCommand {
	public static class Request {
		@Data
		public static class Create {
			private String name;
		}
	}
	
	public static class Response {
		@Data
		@Builder
		public static class Create {
			private Long id;
			private String name;
			private AuthorityCode authority;
		}
	}
}
