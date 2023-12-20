package com.in28minutes.learnspringframework.game;

public class PackMan implements GameConsole {

	public void up() {
		System.out.println("pack jump");
	}
	
	public void down() {
		System.out.println("pack down");
	}
	
	public void left() {
		System.out.println("pack left");
	}
	
	public void right() {
		System.out.println("pack right");
	}
}
