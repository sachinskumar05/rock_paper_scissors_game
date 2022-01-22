package com.sk.rps;

import com.sk.rps.game.RPSEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RpsApplication {

	@Autowired
	private RPSEngine rpsEngine;

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(RpsApplication.class, args);
		RpsApplication rps = ctx.getBean(RpsApplication.class);

		rps.rpsEngine.recordHumanPlayerName();

		do {
			rps.rpsEngine.startGame();
		} while(rps.rpsEngine.isRepeat());

	}

}
