package com.twitters.business.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class CredentialDTO {

	private String loginId;
	private String password;

}
