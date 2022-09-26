package com.twitters.business.dbadapter.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "Reply")
public class ReplyDao {

	@Id
	private String _id;
	private String commentId;
	private String reply;
	private String userId;
}
