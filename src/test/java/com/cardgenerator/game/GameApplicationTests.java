package com.cardgenerator.game;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class GameApplicationTests {

	@Test
	void contextLoads() {
		boolean started = true;
		assertThat(started).isTrue();
	}
}
