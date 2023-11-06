package com.ll.base;

public abstract class CommandHandler {
	public abstract DetailedCommand parseCommand(String cmd);
}