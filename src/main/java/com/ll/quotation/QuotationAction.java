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
		for (Map.Entry<Integer,Quotation> entry : quotationList.entrySet()) {
			int key = entry.getKey();
			Quotation quotation = entry.getValue();
			String formattedString = String.format("%d / %s / %s",key,quotation.getQuotewriter(),quotation.getQuotename());
			System.out.println(formattedString);
		}
	}

	public void deleteQuotation(int num)
	{
		if(quotationList.containsKey(num))
		quotationList.remove(num);
		else {
			System.out.println(num + "번 명언은 존재하지 않습니다.");
			return;
		}

		String formattedString = String.format("%d번 명언이 삭제되었습니다.",num);
		System.out.println(formattedString);
	}
}
