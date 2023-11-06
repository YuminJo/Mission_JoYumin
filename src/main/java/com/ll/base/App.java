package com.ll.base;

import java.util.Scanner;

public class App {
	private Scanner scanner;
	public App() {
	}

	public void run() {
		scanner = new Scanner(System.in);

		System.out.println("== 명언 앱 ==");
		System.out.print("명령) ");

		String command = scanner.nextLine();

		switch(command)
		{
			case "종료": QuitApp(); break;
			case "등록": InsertQuotation(); break;
		}
	}

	private void QuitApp()
	{
		scanner.close();
		System.exit(0);
	}

	private void InsertQuotation()
	{
		System.out.print("명언 : ");
		String quotename = scanner.nextLine();

		System.out.print("작가 : ");
		String quotewriter = scanner.nextLine();
	}
}