package com.ll.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Scanner;

import org.json.JSONArray;

import com.ll.dataclass.Quotation;
import com.ll.service.QuotationService;

public class QuotationController {
	private Scanner scanner;
	private LinkedHashMap<Integer, Quotation> quotationList;
	private int quotationid;

	private final String JSON_FILE_PATH = "src/main/datafile/data.json";
	private final QuotationService quotationService;

	public QuotationController(Scanner scanner) {
		this.scanner = scanner;

		quotationService = new QuotationService();
		quotationList = new LinkedHashMap<>();

		readQuotes();

		quotationid = quotationService.getLastQuotationById(quotationList);
	}

	public void insertQuotation() {
		System.out.print("명언 : ");
		String quotename = scanner.nextLine();

		System.out.print("작가 : ");
		String quotewriter = scanner.nextLine();

		quotationList.put(quotationid, new Quotation(quotename, quotewriter));
		quotationid++;

		System.out.println(quotationid + "번 명언이 등록되었습니다.");
	}

	public void printQuotationList() {
		System.out.println("번호 / 작가 / 명언");
		System.out.println("----------------------");

		quotationList.forEach((key, value) -> {
			System.out.println(key);
			System.out.println(" / ");
			System.out.println(value.getQuotewriter());
			System.out.println(" / ");
			System.out.println(value.getQuotename());
		});
	}

	public void deleteQuotation(int id) {
		Quotation removedQuotation = quotationList.remove(id);

		String message = (removedQuotation != null)
			? id + "번 명언이 삭제되었습니다."
			: "번호 " + id + "에 해당하는 명언을 찾을 수 없습니다.";

		System.out.println(message);
	}

	public void modifyQuotation(int id) {
		if (!quotationList.containsKey(id)) System.out.println(id + "번 명언은 존재하지 않습니다.");
		else {
			System.out.println("명언(기존) : " + quotationList.get(id).getQuotename());
			System.out.print("명언 : ");
			String newQuotename = scanner.nextLine();

			System.out.println("작가(기존) : " + quotationList.get(id).getQuotename());
			System.out.print("작가 : ");
			String newQuotewriter = scanner.nextLine();

			Quotation newQuotation = new Quotation(newQuotename,newQuotewriter);
			quotationList.put(id,newQuotation);
		}
	}

	public void buildQuotation() {
		JSONArray jsonArray = quotationService.createQuotationJSON(quotationList);
		quotationService.writeJSONToFile(jsonArray,JSON_FILE_PATH);
		System.out.println("data.json 파일의 내용이 갱신되었습니다.");
	}

	void readQuotes() {
		if (Files.exists(Paths.get(JSON_FILE_PATH)) && Files.isRegularFile(Paths.get(JSON_FILE_PATH))) {
			try {
				String jsonContent = new String(Files.readAllBytes(Paths.get(JSON_FILE_PATH)));
				JSONArray jsonArray = new JSONArray(jsonContent);

				quotationService.updateQuotationList(jsonArray);
			} catch (IOException e) {
				quotationService.handleFileReadException(e);
			}
		}
	}
}
