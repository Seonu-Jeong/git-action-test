package org.sparta.ci_test;

import org.junit.jupiter.api.Test;
import org.sparta.ci_test.domain.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleServiceTest {

	@Autowired
	private SimpleService simpleService;

	@Test
	public void test() {
		simpleService.simpleFunc();
	}
}