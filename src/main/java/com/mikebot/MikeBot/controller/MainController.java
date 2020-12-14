package com.mikebot.MikeBot.controller;


import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import com.mikebot.MikeBot.controller.Messaging;


public class MainController {
	public void start() {
		// Permission code : 337984
		String token = <insert your token>;
	    //DiscordClientBuilder builder = DiscordClientBuilder.create(token);
		 GatewayDiscordClient client = DiscordClientBuilder.create(token)
	                .build()
	                .login().block();
	                // The whole code is going to place here 
		 // every constructor from any class that I am going to use inside of this class will take GetwayDiscordClient instance
		Messaging msg = new MessagingImpl(client) ;
		msg.replyToCommand();
		msg.send();
		 
		 client.onDisconnect().block();
	}

}
