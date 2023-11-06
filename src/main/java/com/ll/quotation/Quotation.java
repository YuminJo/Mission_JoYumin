package com.ll.quotation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Quotation {

	@Getter
	@Setter
	private String quotename;

	@Getter
	@Setter
	private String quotewriter;
}
