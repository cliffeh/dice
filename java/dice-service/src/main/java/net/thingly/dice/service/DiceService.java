package net.thingly.dice.service;

import org.glassfish.jersey.server.ResourceConfig;

public class DiceService extends ResourceConfig {
	public DiceService() {
		register(DiceResource.class);
	}
}
