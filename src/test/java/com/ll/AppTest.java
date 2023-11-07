package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import com.ll.base.CommandHandler;
import com.ll.base.CommandParser;
import com.ll.base.IdCommandHandler;

public class AppTest extends TestUtil
{
	@Test
	@DisplayName("종료를 입력하면 앱이 종료된다.")
	void testQuitApp()
	{
		systemIn("종료");
		app.run();
		printResult();
	}

	@Test
	@DisplayName("등록을하면 등록이 된다.")
	void testInsertQuotation()
	{
		systemIn("등록\n명언내용\n작가\n종료");
		app.run();
		printResult();
	}

	@Test
	@DisplayName("여러 명언을 등록하면 명언번호가 증가한다.")
	void testMultipleInsertQuotation()
	{
		systemIn("등록\n명언내용\n작가\n등록\n명언내용2\n작가2\n종료");
		app.run();
		printResult();
	}

	@Test
	@DisplayName("등록 후 목록을 출력한다.")
	void testPrintQuotationList()
	{
		systemIn("등록\n명언내용\n작가\n등록\n명언내용2\n작가2\n목록\n종료");
		app.run();
		printResult();
	}

	@Test
	@DisplayName("등록 후 목록을 출력하고 명언을 삭제한다.")
	void testRemoveQuotation()
	{
		systemIn("등록\n명언내용\n작가\n등록\n명언내용2\n작가2\n목록\n삭제?id=1\n종료");
		app.run();
		assertThat(getOutput()).contains("명언이 삭제되었습니다.");
	}

	@Test
	@DisplayName("등록 후 목록을 출력하고 ID 1번을 2번 삭제한다.")
	void testRemoveSameQuotation()
	{
		systemIn("등록\n명언내용\n작가\n등록\n명언내용2\n작가2\n목록\n삭제?id=1\n삭제?id=1\n목록\n종료");
		app.run();
		assertThat(getOutput()).contains("명언은 존재하지 않습니다.");
	}

	@Test
	@DisplayName("등록 후 목록을 출력하고 ID 1번 ID 2번을 삭제한다.")
	void testRemoveSameQuotation2()
	{
		systemIn("등록\n명언내용\n작가\n등록\n명언내용2\n작가2\n목록\n삭제?id=2\n목록\n삭제?id=1\n목록\n종료");
		app.run();
		printResult();
	}

	@Test
	@DisplayName("명령어 예외 테스트1")
	void testRemoveCommandException1()
	{
		CommandHandler commandHandler = new IdCommandHandler();
		CommandParser commandParser = new CommandParser(commandHandler);
		//숫자 인식 오류
		commandParser.parseCommand("Test?id=1!1");
		assertThat(getOutput()).contains("숫자가 정확하지 않습니다.");
	}

	@Test
	@DisplayName("명령어 예외 테스트2")
	void testRemoveCommandException2()
	{
		CommandHandler commandHandler = new IdCommandHandler();
		CommandParser commandParser = new CommandParser(commandHandler);
		//타입 인식 오류
		commandParser.parseCommand("Tesasdt?ab=1");
		assertThat(getOutput()).contains("없는 TYPE 입니다.");
	}

	@Test
	@DisplayName("명령어 예외 테스트3")
	void testRemoveCommandException3()
	{
		CommandHandler commandHandler = new IdCommandHandler();
		CommandParser commandParser = new CommandParser(commandHandler);
		//숫자 인식 오류
		commandParser.parseCommand("Tesasdt?id=1abc");
		assertThat(getOutput()).contains("숫자가 정확하지 않습니다.");
	}

	@Test
	@DisplayName("명언 수정")
	void testModifyQuotation()
	{
		systemIn("등록\n명언내용\n작가\n등록\n명언내용2\n작가2\n목록\n삭제?id=1\n목록\n수정?id=2\n수정된\n명언\n목록\n종료");
		app.run();
		printResult();
	}

	@Test
	@DisplayName("없는 명언 수정")
	void testNoModifyQuotation()
	{
		systemIn("등록\n명언내용\n작가\n등록\n명언내용2\n작가2\n목록\n삭제?id=2\n목록\n수정?id=2\n수정된\n명언\n목록\n종료");
		app.run();
		printResult();
	}

	@Test
	@DisplayName("빌드 명령어 테스트")
	void testBuildQuotation()
	{
		systemIn("등록\n명언내용\n작가1\n등록\n명언내용2\n작가2\n등록\n명언3\n작가3\n목록\n빌드\n종료");
		app.run();
		assertThat(getOutput()).contains("data.json 파일의 내용이 갱신되었습니다.");
	}

	@Test
	@DisplayName("불러오기 테스트")
	void testReadQuotation()
	{
		systemIn("목록\n종료");
		app.run();
		printResult();
	}
}