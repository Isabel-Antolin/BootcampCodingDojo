package com.codingdojo.zooproject.animals;

public class Gorilla extends Mammal {

	public void throwSomething() {
		System.out.println("Gorilla Lanzado algo");
		setEnergyLevel(getEnergyLevel()-5);
	}

	public void eatBananas() {
		System.out.println("Gorilla a comido una banana");
		setEnergyLevel(getEnergyLevel()+10);
	}
	public void clim() {
		System.out.println("Gorilla a trepado a la cima de un árbol");
		setEnergyLevel(getEnergyLevel()+10);
	}

	
}
