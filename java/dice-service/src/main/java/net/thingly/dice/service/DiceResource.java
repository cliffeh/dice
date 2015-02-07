package net.thingly.dice.service;

import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.thingly.dice.Dice;

@Path("dice")
public class DiceResource {

	@GET
	@Path("roll")
	@Produces(MediaType.APPLICATION_JSON)
	public String roll() {
		return "" + Dice.roll();
	}

	@GET
	@Path("roll/{n}")
	@Produces(MediaType.APPLICATION_JSON)
	public String roll(@PathParam(value = "n") int n) {
		return Arrays.toString(Dice.roll(n));
	}

	@GET
	@Path("roll/{n}d{d}")
	@Produces(MediaType.APPLICATION_JSON)
	public String roll(@PathParam(value = "n") int n,
			@PathParam(value = "d") int d) {
		return Arrays.toString(Dice.roll(n, d));
	}
}
