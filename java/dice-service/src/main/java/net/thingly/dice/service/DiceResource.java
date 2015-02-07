package net.thingly.dice.service;

import java.awt.PageAttributes.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("things")
public class DiceResource {

	@GET
	@Path("roll")
	@Produces(MediaType.APPLICATION_JSON)
	public int roll() {
		return Dice.roll();
	}

	@GET
	@Path("roll/{n}")
	@Produces(MediaType.APPLICATION_JSON)
	public int[] roll(@PathParam(value = "n") int n) {
		return Dice.roll(n);
	}

	@GET
	@Path("roll/{n}d{d}")
	@Produces(MediaType.APPLICATION_JSON)
	public int[] roll(@PathParam(value = "n") int n,
			@PathParam(value = "d") int d) {
		return Dice.roll(n, d);
	}
}
