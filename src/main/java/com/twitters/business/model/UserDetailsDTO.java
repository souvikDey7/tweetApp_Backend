package com.twitters.business.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class UserDetailsDTO {
	private String firstName;
	private String lastName;
	private String email;
	private Integer contactNumber;
	private CredentialDTO cridential;

}