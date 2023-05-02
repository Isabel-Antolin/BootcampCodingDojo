package com.isabel.pokedex.objetos;

public class Pokemon {
	private String name, type;
	private int health;
	private static int countPokemones=0;
	
	public Pokemon(String name,int health,String type) {
		this.name =name;
		this.health=health;
		this.type=type;
		countPokemones++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public static int getCount() {
		return countPokemones;
	}
 	void attackPokemon(Pokemon pokemon) {
		pokemon.setHealth(pokemon.getHealth()-10);
	}
}
