package com.bridjit.learning.learning.oca.chap4;

import java.util.Objects;

public class Player {
	private String name;

	public Player() {
		this.name = new String("Mahrez");
	}

	public Player(Player p) {
		this.name = p.name;
	}

	public Player(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Player)) {
			return false;
		}
		Player other = (Player) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Player [name=" + name + "]";
	}

}
