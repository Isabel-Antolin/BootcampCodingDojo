package com.isabel.pokedex.objetos;

public abstract class AbstractPokemon implements PokemonInterface {
	public Pokemon createPokemon(String name, int health, String type) {
		return new Pokemon(name,health,type);
	}
	
	public String pokemonInfo(Pokemon pokemon) {
		return String.format("Name: %s , Health: %d, Type: %s", pokemon.getName(),pokemon.getHealth(),pokemon.getType());
	}
}
