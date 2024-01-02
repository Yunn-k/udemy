package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GameConsole {

	public void up() {
		System.out.println("Mario Jump");
	}
	
	public void down() {
		System.out.println("Mario down");
	}
	
	public void left() {
		System.out.println("Mario left");
	}
	
	public void right() {
		System.out.println("Mario right");
	}
}
