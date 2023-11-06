package com.ll;

import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import com.ll.base.App;

public class AppTest extends TestUtil
{
	@Test
	@DisplayName("종료를 입력하면 앱이 종료된다.")
	void testQuitApp()
	{
		systemIn("종료");
		app.run();
		printResult();`
	}

	@Test
	@DisplayName("등록을하면 등록이 된다.")
	void testInsertQuotation()
	{
		systemIn("등록\n명언내용\n작가");
		app.run();
		printResult();
	}
}