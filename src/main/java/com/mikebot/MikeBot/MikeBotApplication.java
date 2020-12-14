package com.mikebot.MikeBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mikebot.MikeBot.controller.MainController;

@SpringBootApplication
public class MikeBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(MikeBotApplication.class, args);
		MainController st = new MainController();
		st.start();
	}

}
