package com.mikebot.MikeBot.controller;

public interface Messaging {
	String recv();
	void send();
	void replyToCommand();
}
