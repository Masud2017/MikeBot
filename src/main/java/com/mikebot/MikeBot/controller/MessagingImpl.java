package com.mikebot.MikeBot.controller;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;

public class MessagingImpl implements Messaging {
	GatewayDiscordClient client;
	
	public MessagingImpl(GatewayDiscordClient client) {
		this.client = client;
	}
	
	@Override
	public String recv() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void send() {
		client.getEventDispatcher().on(MessageCreateEvent.class)
		.map(MessageCreateEvent::getMessage) // Short hand for map(event -> event.getMessage() )
		.filter(message -> message.getAuthor().map(user-> !user.isBot()).orElse(false))
		.filter(message -> message.getContent().equalsIgnoreCase("!hello"))
		.flatMap(Message::getChannel)
		.flatMap(channel -> channel.createMessage("Hello world!!")).subscribe();

	}
	@Override
	public void replyToCommand() {
		 client.getEventDispatcher().on(MessageCreateEvent.class)
	        .map(MessageCreateEvent::getMessage)
	        .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
	        .filter(message -> message.getContent().equalsIgnoreCase("!ping"))
	        .flatMap(Message::getChannel)
	        .flatMap(channel -> channel.createMessage("Pong!"))
	        .subscribe();
	}

}
