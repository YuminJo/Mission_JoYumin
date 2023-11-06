package com.ll.quotation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import com.ll.error.ErrorList;

public class QuotationAction {
	private Scanner scanner;
	private LinkedHashMap<Integer,Quotation> quotationList;
	private ErrorList errorList;

	public QuotationAction(Scanner scanner)
	{
		this.scanner = scanner;
		quotationList = new LinkedHashMap<>();
		errorList = new ErrorList();
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
		for(int i = 1; i <= quotationList.size(); i++) {
			Quotation quotation = quotationList.get(i);
			String formattedString = String.format("%d / %s / %s",i,quotation.getQuotewriter(),quotation.getQuotename());
			System.out.println(formattedString);
		}
	}

	public void deleteQuotation(int num)
	{
		if(quotationList.containsKey(num))
		quotationList.remove(num);
		else {
			errorList.errorNumber(num);
			return;
		}

		String formattedString = String.format("%d번 명언이 삭제되었습니다.",num);
		System.out.println(formattedString);
	}
}
