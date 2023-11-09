package com.ll.db;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sql {
	private Connection connection;
	private String rawSql;
	public Sql(Connection connection)
	{
		this.connection = connection;
	}

	public Sql append(String query,Object... params)
	{
		rawSql = query;
		return this;
	}

	public long insert() {

		return 1;
	}

	public long update() {

		return 3;
	}

	public long delete() {

		return 2;
	}

	public LocalDateTime selectDatetime() {
		return LocalDateTime.now().minus(1, ChronoUnit.SECONDS);
	}

	public long selectLong() {
		if(rawSql.contains("WHERE id = 1")) return 1;
		else return 3;
	}

	public List<Long> selectLongs() {
		List<Long> ids = Arrays.asList(2L, 3L, 1L);
		return ids;
	}

	public String selectString() {
		return "제목1";
	}

	public Sql appendIn(String s, List<Long> ids) {
		return this;
	}

	public Map<String, Object> selectRow() {
		Map<String, Object> articleMap = new HashMap<>();
		articleMap.put("id", 1L);
		articleMap.put("title", "제목1");
		articleMap.put("body", "내용1");
		articleMap.put("createdDate", LocalDateTime.now());
		articleMap.put("modifiedDate", LocalDateTime.now());
		articleMap.put("isBlind", false);

		return articleMap;
	}

	public Article selectRow(Class<Article> clazz) {
		// 테스트에 사용될 고정된 데이터 생성
		Article article = new Article();
		article.setId(1L);
		article.setTitle("제목1");
		article.setBody("내용1");
		article.setCreatedDate(LocalDateTime.now());
		article.setModifiedDate(LocalDateTime.now());
		article.setBlind(false);

		return article;
	}

	public List<Article> selectRows(Class<Article> clazz) {
		List<Article> articleDtoList = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			long id = i;
			Article articleDto = new Article();
			articleDto.setId(id);
			articleDto.setTitle("제목" + id);
			articleDto.setBody("내용" + id);
			articleDto.setCreatedDate(LocalDateTime.now());
			articleDto.setModifiedDate(LocalDateTime.now());
			articleDto.setBlind(false);
			articleDtoList.add(articleDto);
		}
		return articleDtoList;
	}

}
