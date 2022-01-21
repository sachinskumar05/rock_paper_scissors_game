package com.sk.rps;

import com.sk.rps.game.RPSEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpsApplication {

	public static void main(String[] args) {

		SpringApplication.run(RpsApplication.class, args);

		RPSEngine rpsLogic = new RPSEngine();

		//get the player's name
		rpsLogic.recordHumanPlayerName();

		//start the game
		rpsLogic.startGame();


	}

}
