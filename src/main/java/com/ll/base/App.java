package com.ll.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ll.quotation.Quotation;

public class App {
	private Scanner scanner;
	private List<Quotation> quotationList;

	public App()
	{
		quotationList = new ArrayList<>();
	}

	public void run() {
		scanner = new Scanner(System.in);

		System.out.println("== 명언 앱 ==");

		while(true) {
			System.out.print("명령) ");

			String command = scanner.nextLine();

			switch (command) {
				case "종료":
					scanner.close();
					return;
				case "등록":
					InsertQuotation();
					break;
			}
		}
	}

	private void InsertQuotation()
	{
		System.out.print("명언 : ");
		String quotename = scanner.nextLine();

		System.out.print("작가 : ");
		String quotewriter = scanner.nextLine();

		quotationList.add(new Quotation(quotationList.size()+1,quotename,quotewriter));

		String formattedString = String.format("%d번 명언이 등록되었습니다.",quotationList.size());
		System.out.println(formattedString);
	}
}