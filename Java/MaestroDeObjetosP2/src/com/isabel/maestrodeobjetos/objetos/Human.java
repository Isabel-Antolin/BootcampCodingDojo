package com.isabel.maestrodeobjetos.objetos;

public class Human {
	protected int strength=3, intelligence=3, stealth=3, health = 100;

	public void display() {
		System.out.println(String.format("strength: %d , intelligence: %d, stealth: %d, health: %d", strength,intelligence, stealth, health));
	}
	
	public void attack(Human personaje) {
		personaje.health -= this.strength;
	}
	
}
