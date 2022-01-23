package com.sk.rps;

import com.sk.rps.game.RPSEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RpsApplicationTests {

	@Autowired
	private RPSEngine rpsEngine;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(rpsEngine);
	}

}
