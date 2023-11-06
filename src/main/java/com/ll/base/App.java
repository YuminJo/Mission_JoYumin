package com.ll.base;
import java.util.Scanner;
import com.ll.quotation.QuotationAction;

public class App {
	private Scanner scanner;
	private QuotationAction quotationAction;

	public App()
	{
	}

	public void run() {
		scanner = new Scanner(System.in);
		quotationAction = new QuotationAction(scanner);

		System.out.println("== 명언 앱 ==");

		while(true) {
			System.out.print("명령) ");

			DetailedCommand detailedCommand = new DetailedCommand(scanner.nextLine());

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
			}
		}
	}
}