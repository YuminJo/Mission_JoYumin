package com.ll.db;

import java.sql.Connection;

public class SimpleDb {
	private Connection connection;
	private boolean devMode;
	private final String url = "";
	public SimpleDb(String host, String root, String not, String name)
	{
		//연결관련 무언가..
	}

	public Sql genSql()
	{
		return new Sql(this.connection);
	}

	public void run(String sql)
	{
		//Run Logic
	}

	public void setDevMode(boolean active)
	{
		devMode = active;
		//DevMode Logic
	}
}
