package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameConsole;
import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PackMan;

@Configuration
public class GamingConfiguration {
	
	@Bean
	public GameConsole game() {
		var game = new PackMan();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GameConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}

}
