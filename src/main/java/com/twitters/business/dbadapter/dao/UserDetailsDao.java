package com.twitters.business.dbadapter.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//@Entity
@Document(collection = "UserDetalis")
//@Table(name = "UserDetalis")
public class UserDetailsDao {

	@Id
	// @Column(name = "UserId")
	private String userId;

//	@Column(name = "First_Name")
	private String firstName;

//	@Column(name = "last_name")
	private String lastName;

//	@Column(name = "Email")
	private String email;

//	@Column(name = "ContactNumber")
	private Integer contactNumber;
}