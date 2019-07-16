package com.bridjit.learning.learning.oca.chap4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.sound.midi.Soundbank;

public class Expirement2 {

	public static void main(String[] args) {
		Player mahrez = new Player(),
		djamel = new Player("Djamel"),
		baghdad = new  Player("Baghdad");
		
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(mahrez);
		players.add(djamel);
		players.add(baghdad);
		
		ArrayList<Player> constructorCopy = new ArrayList<Player>(players);
		ArrayList<Player> cloneCopy = (ArrayList<Player>) players.clone();
		ArrayList<Player> referenceCopy = players;
		ArrayList<Player> deepCopy = new ArrayList<Player>(players.stream().map((p)-> new Player(p)).collect(Collectors.toList()));
		
		System.out.println("checking new references creation");
		System.out.println(players == constructorCopy);
		System.out.println(players == cloneCopy);
		System.out.println(players == referenceCopy);
		System.out.println(players == deepCopy);
		
		System.out.println();
		
		System.out.println("checking content refs");
		
		players.get(0).setName("changed");
		
		System.out.println(players);
		System.out.println(constructorCopy);
		System.out.println(cloneCopy);
		System.out.println(referenceCopy);
		System.out.println(deepCopy);
		
		System.out.println();
		
		System.out.println("checking list orders ");
		players.remove(1);

		System.out.println(players);
		System.out.println(constructorCopy);
		System.out.println(cloneCopy);
		System.out.println(referenceCopy);
		System.out.println(deepCopy);
		
		players.add( players.remove(0));

		System.out.println();
		
		System.out.println("checking list orders ");
		System.out.println(players);
		System.out.println(constructorCopy);
		System.out.println(cloneCopy);
		System.out.println(referenceCopy);
		System.out.println(deepCopy);
		
		
	}
}
