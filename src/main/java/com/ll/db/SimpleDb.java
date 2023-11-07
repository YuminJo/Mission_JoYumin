package com.ll.db;

public class SimpleDb {
	private boolean devMode;
	private final String url = "";
	public SimpleDb(String host, String root, String not, String name)
	{
		//연결관련 무언가..
	}

	public void run(String sql)
	{

	}

	public void setDevMode(boolean active)
	{
		devMode = active;
	}
}
