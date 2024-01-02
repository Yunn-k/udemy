package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component //특정 클래스의 인스턴스 생성을 Spring에 요청
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
