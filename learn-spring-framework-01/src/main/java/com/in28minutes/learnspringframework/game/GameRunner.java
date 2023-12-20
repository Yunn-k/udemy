package com.in28minutes.learnspringframework.game;

public class GameRunner {
	
	//private MarioGame game;
	private GameConsole game;
	
	//기본생성자
	public GameRunner(GameConsole game) {
		this.game = game;
	}

	public void run() {
		System.out.println("Running Game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
