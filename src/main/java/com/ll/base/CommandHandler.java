package com.ll.base;

import com.ll.dataclass.DetailedCommand;

public abstract class CommandHandler {
	public abstract DetailedCommand parseCommand(String cmd);
}