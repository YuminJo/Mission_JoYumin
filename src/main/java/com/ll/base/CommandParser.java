package com.ll.base;

public class CommandParser {
	private CommandHandler commandHandler;

	public CommandParser(CommandHandler commandHandler) {
		this.commandHandler = commandHandler;
	}

	public DetailedCommand parseCommand(String cmd) {
		return commandHandler.parseCommand(cmd);
	}
}