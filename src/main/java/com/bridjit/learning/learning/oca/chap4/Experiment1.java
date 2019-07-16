package com.bridjit.learning.learning.oca.chap4;

import java.util.Arrays;

/**
 * Messing with java String refs in arrays ;)
 */
public class Experiment1 {

	public static void main(String[] args) {
		Player mahrez = new Player();

		Player[] players = new Player[10];

		for (int i = 0; i < players.length; i++) {
			players[i] = mahrez;
		}

		System.out.println(Arrays.deepToString(players)); // should print 10 mahrezes

		players[0].setName("Taleb");

		System.out.println(Arrays.deepToString(players)); // should print 10 Talebs

		System.out.println("///////// new  experiments ///////////");
		players[0].setName("mahrez");

		for (int i = 0; i < players.length; i++) {
			players[i] = new Player(mahrez);
		}

		System.out.println(Arrays.deepToString(players)); // should print 10 mahrezes

		players[0].setName("Taleb");

		System.out.println(Arrays.deepToString(players)); // should print 1 Talebs

	}
}
