package com.ll.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ll.dataclass.Quotation;

public class QuotationService {

	public int getLastQuotationById(LinkedHashMap<Integer, Quotation> quotationList)
	{
		return quotationList.keySet().stream()
			.max(Integer::compare)
			.map(maxIndex -> maxIndex + 1)
			.orElse(1);
	}

	public JSONArray createQuotationJSON(LinkedHashMap<Integer, Quotation> quotationList)
	{
		return quotationList.entrySet().stream()
			.map(entry -> {
				int id = entry.getKey();
				Quotation quotation = entry.getValue();

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", id);
				jsonObject.put("content", quotation.getQuotename());
				jsonObject.put("author", quotation.getQuotewriter());
				return jsonObject;
			})
			.collect(JSONArray::new, JSONArray::put, JSONArray::put);
	}

	public void writeJSONToFile(JSONArray jsonArray, String JSON_FILE_PATH) {
		try (FileWriter file = new FileWriter(JSON_FILE_PATH)) {
			file.write(jsonArray.toString(4));
			file.flush();
		} catch (IOException e) {
			handleFileWriteException(e);
		}
	}

	public LinkedHashMap<Integer, Quotation> updateQuotationList(JSONArray jsonArray) {
		LinkedHashMap<Integer, Quotation> quotationList = IntStream.range(0, jsonArray.length())
			.mapToObj(i -> jsonArray.getJSONObject(i))
			.collect(Collectors.toMap(
				i -> i.getInt("id"),
				i -> new Quotation(i.getString("content"), i.getString("author")),
				(e1, e2) -> e1, // Handle duplicates
				LinkedHashMap::new
			));
		return quotationList;
	}

	private void handleFileWriteException(IOException e) {
		System.out.println("에러: 파일을 저장하는데 실패했습니다 - " + e.getMessage());
		throw new RuntimeException("파일 저장 중 오류 발생", e);
	}

	public void handleFileReadException(IOException e) {
		System.out.println("에러: 파일을 불러오는데 실패하였습니다 - " + e.getMessage());
		throw new RuntimeException("파일 읽기 중 오류 발생", e);
	}
}