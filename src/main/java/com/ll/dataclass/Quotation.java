package com.ll.dataclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
<<<<<<< HEAD
@Getter
@Setter
public class Quotation {
	private String quotename;
=======
public class Quotation {

	@Getter
	@Setter
	private String quotename;

	@Getter
	@Setter
>>>>>>> 5f010fe5d724b8be849bd9693de77048d5384486
	private String quotewriter;
}
