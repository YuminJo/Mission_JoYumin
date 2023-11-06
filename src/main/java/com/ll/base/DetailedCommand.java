package com.ll.base;

import com.ll.error.ErrorList;

import lombok.Getter;

public class DetailedCommand {
	@Getter
	private String mainCommand;
	@Getter
	private int number;

	private ErrorList errorList;

	public DetailedCommand(String cmd) {
		errorList = new ErrorList();
		getCommand(cmd);
	}

	public void getCommand(String cmd) {
		String[] parts = cmd.split("\\?");
		if (parts.length == 1) {
			mainCommand = parts[0];
			return;
		}

		String[] keyValues = parts[parts.length - 1].split("=");
		if (keyValues.length != 2) {
			mainCommand = "";
			errorList.errorCommand();
			return;
		}

		String key = keyValues[0];
		String value = keyValues[1];

		if ("id".equals(key)) {
			mainCommand = key;
			try {
				number = Integer.parseInt(value);
				mainCommand = parts[0];
			} catch (NumberFormatException e) {
				errorList.errorNumber(0);
				mainCommand = "";
			}
		} else {
			errorList.noEqualType();
			mainCommand = "";
		}
	}
}
