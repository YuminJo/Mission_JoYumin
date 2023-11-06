package com.ll.error;

public class ErrorList {
	public void noEqualType()
	{
		System.out.println("잘못된 타입입니다.");
	}

	public void errorCommand()
	{
		System.out.println("잘못된 명령어입니다..");
	}

	public void errorNumber(int number)
	{
		System.out.println(number + "번 명언은 존재하지 않습니다.");
	}
}
