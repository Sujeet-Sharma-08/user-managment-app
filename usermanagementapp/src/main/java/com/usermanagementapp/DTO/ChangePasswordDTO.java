package com.usermanagementapp.DTO;

import lombok.Data;


@Data
public class ChangePasswordDTO {
	
	private String currentPassword;
	
	private String newPassword;
	
	private String confirmPassword;

}
