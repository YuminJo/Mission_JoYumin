package com.ll.dataclass;

import lombok.Getter;
import lombok.Setter;

<<<<<<< HEAD
@Getter @Setter
public class DetailedCommand {
	private String mainCommand;
=======
public class DetailedCommand {
	@Getter @Setter
	private String mainCommand;
	@Getter @Setter
>>>>>>> 5f010fe5d724b8be849bd9693de77048d5384486
	private int number;
}