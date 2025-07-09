package com.usermanagementapp.DTO;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@
public class UserDTO {
	
	@Id
	private Long id;
	
	@NotBlank
	@Size(min =3 ,max=50)
	private String userName;
	
	@NotBlank
	@Size(max=70)
	@Email
	private String email;
	
}
