package com.in28minutes.learnspringframework;

import java.net.UnknownHostException;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PackMan;

public class App01GamingBasicJava {

	public static void main(String[] args) throws UnknownHostException {
		
		var game = new PackMan();
//		var game = new MarioGame();
//		var game = new SuperContraGame();
		var gameRunner = new GameRunner(game);
		gameRunner.run();

		
		//IP알아보기
//		InetAddress localhost = InetAddress.getLocalHost();
//		System.out.println("네트워크 아이피 주소"+ localhost.getHostAddress());
		
	}

}


