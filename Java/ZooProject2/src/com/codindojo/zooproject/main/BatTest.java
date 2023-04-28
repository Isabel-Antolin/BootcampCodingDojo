package com.codindojo.zooproject.main;
import com.codingdojo.zooproject.animals.Bat;

public class BatTest {
public static void main(String[] args) {
    //----Bat---
	Bat murcielago = new Bat();
	
	for (int i = 1; i <= 3; i++) {
		murcielago.attackTown();
	}
	for (int i = 1; i <= 2; i++) {
		murcielago.eatHumans();
	}
	
	for (int i = 1; i <= 2; i++) {
		murcielago.fly();
	}
	
	murcielago.displayEnergy();
	

}
}
