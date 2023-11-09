package com.ll.base;
import java.util.Scanner;

import com.ll.controller.QuotationController;
import com.ll.dataclass.DetailedCommand;

public class App {
	private Scanner scanner;
	private QuotationController quotationAction;
	private CommandParser commandParser;

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
				case "종료":
					scanner.close();
					return;
				case "등록":
					quotationAction.insertQuotation();
					break;
				case "목록":
					quotationAction.printQuotationList();
					break;
				case "삭제":
					quotationAction.deleteQuotation(detailedCommand.getNumber());
					break;
				case "수정":
					quotationAction.modifyQuotation(detailedCommand.getNumber());
					break;
				case "빌드":
					quotationAction.buildQuotation();
					break;
			}
		}
	}
}