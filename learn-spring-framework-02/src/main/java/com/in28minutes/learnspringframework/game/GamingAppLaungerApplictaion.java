package com.in28minutes.learnspringframework.game;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game") // 스캔할 페이지 지정
public class GamingAppLaungerApplictaion {

//	@Bean
//	public GameConsole game() {
//		var game = new PackMan();
//		return game;
//	}

//	@Bean
//	public GameRunner gameRunner(GameConsole game) {
//		var gameRunner = new GameRunner(game);
//		return gameRunner;
//	}

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(GamingAppLaungerApplictaion.class)) {
//			context.getBean(GameConsole.class).up();
			context.getBean(GameRunner.class).run();
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
}
