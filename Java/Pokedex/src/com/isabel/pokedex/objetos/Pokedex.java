package com.isabel.pokedex.objetos;
import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {
	private ArrayList<Pokemon> myPokemons = new ArrayList<>();

	public void listPokemon() {
	    for (Pokemon pokemon : myPokemons) {
	        System.out.println(pokemon.getName());
	    }
	}

	public void addPokemon(Pokemon pokemon) {
	    myPokemons.add(pokemon);
	}
}
