package com.codindojo.zooproject.main;
import com.codingdojo.zooproject.animals.Gorilla;

public class GorillaTest {
	public static void main(String[] args) {
		Gorilla dk = new Gorilla();
		
		for (int i = 1; i <= 3; i++) {
			dk.throwSomething();
		}
		
		for (int i = 1; i <= 2; i++) {
			dk.eatBananas();
		}
		
		dk.clim();
		dk.displayEnergy();

	}
}
