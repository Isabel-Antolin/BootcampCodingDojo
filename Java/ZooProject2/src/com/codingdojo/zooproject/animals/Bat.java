package com.codingdojo.zooproject.animals;

public class Bat extends Mammal {
	public Bat() {
		this.setEnergyLevel((300));
	}
	
	public void fly() {
		System.out.println("Murciélago volando ......");
		setEnergyLevel(getEnergyLevel()- 50);
	}
	public void eatHumans() {
		System.out.println("Bueno,no importa ......");
		setEnergyLevel(getEnergyLevel()+ 25);
	}
	public void attackTown() {
		System.out.println("Sonido de la ciudad en llamas ......");
		setEnergyLevel(getEnergyLevel()- 100);
	}
}
