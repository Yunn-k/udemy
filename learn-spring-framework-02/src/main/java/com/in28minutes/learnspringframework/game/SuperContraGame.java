package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GameConsole{
	
	public void up() {
		System.out.println("super Jump");
	}
	
	public void down() {
		System.out.println("super down");
	}
	
	public void left() {
		System.out.println("super left");
	}
	
	public void right() {
		System.out.println("super right");
	}

}
