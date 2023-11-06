package com.ll.base;

import com.ll.dataclass.DetailedCommand;

public class CommandParser {
	private CommandHandler commandHandler;

	public CommandParser(CommandHandler commandHandler) {
		this.commandHandler = commandHandler;
	}

	public DetailedCommand parseCommand(String cmd) {
		return commandHandler.parseCommand(cmd);
	}
}