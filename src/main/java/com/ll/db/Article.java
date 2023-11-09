package com.ll.db;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Article {
	private long id;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private String title;
	private String body;
	private boolean isBlind;
}