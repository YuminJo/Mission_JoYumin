package com.ll.db;

import java.sql.Connection;
import java.time.LocalDateTime;

public class Sql {
	private Connection connection;
	public Sql(Connection connection)
	{
		this.connection = connection;
	}

	public Sql append(String query,Object... params)
	{
		return this;
	}

	public long insert() {
		// Implement the logic for executing insert query and returning generated ID
		return 0;
	}

	public long update() {
		// Implement the logic for executing update query and returning affected rows count
		return 0;
	}

	public long delete() {
		// Implement the logic for executing delete query and returning affected rows count
		return 0;
	}

	public LocalDateTime selectDatetime() {
		// Implement the logic for executing select query and returning LocalDateTime
		return null;
	}
}
