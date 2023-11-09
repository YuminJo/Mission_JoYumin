package com.ll.base;
import java.util.Scanner;

<<<<<<< HEAD
import com.ll.controller.QuotationController;
=======
>>>>>>> 5f010fe5d724b8be849bd9693de77048d5384486
import com.ll.dataclass.DetailedCommand;

public class App {
	private Scanner scanner;
<<<<<<< HEAD
	private QuotationController quotationAction;
	private CommandParser commandParser;

	private final String EXIT = "종료";
	private final String REGISTER = "등록";
	private final String LIST = "목록";
	private final String DELETE = "삭제";
	private final String MODIFY = "수정";
	private final String BUILD = "빌드";

=======
	private QuotationAction quotationAction;
	private CommandParser commandParser;

>>>>>>> 5f010fe5d724b8be849bd9693de77048d5384486
	public App()
	{
		CommandHandler commandHandler = new IdCommandHandler();
		commandParser = new CommandParser(commandHandler);
	}

	public void run() {
		scanner = new Scanner(System.in);
<<<<<<< HEAD
		quotationAction = new QuotationController(scanner);
=======
		quotationAction = new QuotationAction(scanner);
>>>>>>> 5f010fe5d724b8be849bd9693de77048d5384486

		System.out.println("== 명언 앱 ==");

		while(true) {
			System.out.print("명령) ");

			DetailedCommand detailedCommand = commandParser.parseCommand(scanner.nextLine());

			switch (detailedCommand.getMainCommand()) {
<<<<<<< HEAD
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
=======
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
>>>>>>> 5f010fe5d724b8be849bd9693de77048d5384486
					quotationAction.buildQuotation();
					break;
			}
		}
	}
}