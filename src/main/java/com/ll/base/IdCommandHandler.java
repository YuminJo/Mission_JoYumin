package com.ll.base;

import com.ll.dataclass.DetailedCommand;

public class IdCommandHandler extends CommandHandler {
	@Override
	public DetailedCommand parseCommand(String cmd) {
		DetailedCommand detailedCommand = new DetailedCommand();
		String[] parts = cmd.split("\\?");
		if (parts.length == 1) {
			detailedCommand.setMainCommand(parts[0]);
		} else {
			String queryPart = parts[parts.length - 1];
			String[] keyValues = queryPart.split("=");

			if (keyValues.length != 2) {
				return handleInvalidCommand("에러 : TYPE이 누락되어 있습니다.");
			}

			String key = keyValues[0];
			String value = keyValues[1];

			if ("id".equals(key)) {
				detailedCommand.setMainCommand(parts[0]);
				try {
					detailedCommand.setNumber(Integer.parseInt(value));
				} catch (NumberFormatException e) {
					return handleInvalidCommand("에러 : 숫자가 정확하지 않습니다.");
				}
			} else {
				return handleInvalidCommand("에러 : 없는 TYPE 입니다.");
			}
		}
		return detailedCommand;
	}

	private DetailedCommand handleInvalidCommand(String errorMessage) {
		System.out.println(errorMessage);
		DetailedCommand errorCommand = new DetailedCommand();
		errorCommand.setMainCommand("");
		return errorCommand;
	}
}