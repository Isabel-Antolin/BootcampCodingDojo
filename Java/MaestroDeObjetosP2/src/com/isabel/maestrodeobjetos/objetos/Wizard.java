package com.isabel.maestrodeobjetos.objetos;

public class Wizard extends Human{

	public Wizard() {
		this.health = 50;
		this.intelligence = 8;
		
		// TODO Auto-generated constructor stub
	}
	
	public void heal(Human personaje) {
		personaje.health += this.intelligence;
	}
	
	public void fireBall(Human personaje) {
		personaje.health -= this.intelligence * 3;
	}

	
}
