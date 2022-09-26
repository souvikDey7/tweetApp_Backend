package com.twitters.business.dbadapter.dao;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "Post")
public class PostDao {

	@Id
	private String _id;

	private String userId;

	private String postData;

	private Integer like = 0;

	private Date time;
}
