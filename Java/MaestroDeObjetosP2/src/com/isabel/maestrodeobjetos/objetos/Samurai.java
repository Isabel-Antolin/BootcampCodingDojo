package com.isabel.maestrodeobjetos.objetos;

public class Samurai extends Human {
    protected int countSamurai;
    
	public Samurai() {
		this.health=200;
		this.countSamurai++;
	}
	
	public void deathBlow(Human personaje) {
		personaje.health= 0;
		this.health /=2;
	}
	
	public void meditate() {
		this.health += (this.health/2);
	}
	
	public int howMany() {
		return this.countSamurai;
	}
	
	
}
