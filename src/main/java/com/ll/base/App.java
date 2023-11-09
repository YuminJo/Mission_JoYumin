package com.ll.base;
import java.util.Scanner;

import com.ll.controller.QuotationController;
import com.ll.dataclass.DetailedCommand;

public class App {
	private Scanner scanner;
	private QuotationController quotationAction;
	private CommandParser commandParser;

	private final String EXIT = "종료";
	private final String REGISTER = "등록";
	private final String LIST = "목록";
	private final String DELETE = "삭제";
	private final String MODIFY = "수정";
	private final String BUILD = "빌드";

	public App()
	{
		CommandHandler commandHandler = new IdCommandHandler();
		commandParser = new CommandParser(commandHandler);
	}

	public void run() {
		scanner = new Scanner(System.in);
		quotationAction = new QuotationController(scanner);

		System.out.println("== 명언 앱 ==");

		while(true) {
			System.out.print("명령) ");

			DetailedCommand detailedCommand = commandParser.parseCommand(scanner.nextLine());

			switch (detailedCommand.getMainCommand()) {
				case EXIT:
					scanner.close();
					return;
				case REGISTER:
					quotationAction.insertQuotation();
					break;
				case LIST:
					quotationAction.printQuotationList();
					break;
				case DELETE:
					quotationAction.deleteQuotation(detailedCommand.getNumber());
					break;
				case MODIFY:
					quotationAction.modifyQuotation(detailedCommand.getNumber());
					break;
				case BUILD:
					quotationAction.buildQuotation();
					break;
			}
		}
	}
}