package com.twitters.business.dbadapter.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Document(collection = "Credentials")
public class CredentialDao {
	@Id
	private String userId;

	private String password;

}
