package com.ll.dataclass;

import lombok.Getter;
import lombok.Setter;

public class DetailedCommand {
	@Getter @Setter
	private String mainCommand;
	@Getter @Setter
	private int number;
}