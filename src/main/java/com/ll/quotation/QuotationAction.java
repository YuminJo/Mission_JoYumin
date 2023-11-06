package com.ll.quotation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class QuotationAction {
	private Scanner scanner;
	private LinkedHashMap<Integer,Quotation> quotationList;

	public QuotationAction(Scanner scanner)
	{
		this.scanner = scanner;
		quotationList = new LinkedHashMap<>();
	}

	public void insertQuotation()
	{
		System.out.print("명언 : ");
		String quotename = scanner.nextLine();

		System.out.print("작가 : ");
		String quotewriter = scanner.nextLine();

		quotationList.put(quotationList.size()+1, new Quotation(quotename,quotewriter));

		String formattedString = String.format("%d번 명언이 등록되었습니다.",quotationList.size());
		System.out.println(formattedString);
	}

	public void printQuotationList()
	{
		System.out.println("번호 / 작가 / 명언");
		System.out.println("----------------------");

		for (Map.Entry<Integer,Quotation> entry : quotationList.entrySet()) {
			int key = entry.getKey();
			Quotation quotation = entry.getValue();
			String formattedString = String.format("%d / %s / %s",key,quotation.getQuotewriter(),quotation.getQuotename());
			System.out.println(formattedString);
		}
	}

	public void deleteQuotation(int num) {
		Quotation removedQuotation = quotationList.remove(num);
		if (removedQuotation != null) {
			System.out.println(num + "번 명언이 삭제되었습니다.");
		} else {
			System.out.println(num + "번 명언은 존재하지 않습니다.");
		}
	}

	public void modifyQuotation(int num) {
		Quotation modifyQuotation = quotationList.get(num);
		if (modifyQuotation != null) {
			System.out.println("명언(기존) : " + modifyQuotation.getQuotename());
			System.out.print("명언 : ");
			String newQuotename = scanner.nextLine();


			System.out.println("작가(기존) : " + modifyQuotation.getQuotewriter());
			System.out.print("작가 : ");
			String newQuotewriter = scanner.nextLine();

			modifyQuotation.setQuotename(newQuotename);
			modifyQuotation.setQuotewriter(newQuotewriter);
		} else {
			System.out.println(num + "번 명언은 존재하지 않습니다.");
		}
	}
}
