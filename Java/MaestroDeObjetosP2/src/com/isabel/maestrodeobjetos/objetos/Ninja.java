package com.isabel.maestrodeobjetos.objetos;

public class Ninja extends Human {

	public Ninja() {
		this.stealth = 10;
		// TODO Auto-generated constructor stub
	}
	
	public void steal(Human personaje) {
		personaje.health -= this.stealth;
		this.health+= this.stealth;
	}
	
	public void runAway() {
		this.health -=10;
	}
	
	

}
