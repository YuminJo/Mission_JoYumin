package com.ll.base;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ll.dataclass.Quotation;

public class QuotationAction {
	private Scanner scanner;
	private LinkedHashMap<Integer, Quotation> quotationList;
	private final String JSON_FILE_PATH = "C:/Users/zkzkt/Downloads/data.json";

	public QuotationAction(Scanner scanner) {
		this.scanner = scanner;
		quotationList = new LinkedHashMap<>();
		readQuotes();
	}

	public void insertQuotation() {
		System.out.print("명언 : ");
		String quotename = scanner.nextLine();

		System.out.print("작가 : ");
		String quotewriter = scanner.nextLine();

		int index = quotationList.keySet().stream()
			.max(Integer::compare)
			.map(maxIndex -> maxIndex + 1)
			.orElse(1);

		quotationList.put(index, new Quotation(quotename, quotewriter));
		System.out.println(index + "번 명언이 등록되었습니다.");
	}

	public void printQuotationList() {
		System.out.println("번호 / 작가 / 명언");
		System.out.println("----------------------");

		quotationList.entrySet().stream()
			.forEach(entry -> {
				int key = entry.getKey();
				Quotation quotation = entry.getValue();
				System.out.println(key + " / " + quotation.getQuotewriter() + " / " + quotation.getQuotename());
			});
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

	public void buildQuotation() {
		JSONArray jsonArray = quotationList.entrySet().stream()
			.map(entry -> {
				int key = entry.getKey();
				Quotation quotation = entry.getValue();

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", key);
				jsonObject.put("content", quotation.getQuotename());
				jsonObject.put("author", quotation.getQuotewriter());
				return jsonObject;
			})
			.collect(JSONArray::new, JSONArray::put, JSONArray::put);

		try (FileWriter file = new FileWriter(JSON_FILE_PATH)) {
			file.write(jsonArray.toString(4));
			file.flush();
			System.out.println("data.json 파일의 내용이 갱신되었습니다.");
		} catch (IOException e) {
			System.out.println("에러: 파일을 저장하는데 실패하였습니다!");
			throw new RuntimeException(e);
		}
	}

	void readQuotes() {
		if (Files.exists(Paths.get(JSON_FILE_PATH)) && Files.isRegularFile(Paths.get(JSON_FILE_PATH))) {
			try {
				String jsonContent = new String(Files.readAllBytes(Paths.get(JSON_FILE_PATH)));
				JSONArray jsonArray = new JSONArray(jsonContent);

				quotationList = IntStream.range(0, jsonArray.length())
					.mapToObj(i -> jsonArray.getJSONObject(i))
					.collect(Collectors.toMap(
						i -> i.getInt("id"),
						i -> new Quotation(i.getString("content"), i.getString("author")),
						(e1, e2) -> e1, // Handle duplicates
						LinkedHashMap::new
					));
			} catch (IOException e) {
				System.out.println("에러: 파일을 불러오는데 실패하였습니다!");
				throw new RuntimeException(e);
			}
		}
	}
}
