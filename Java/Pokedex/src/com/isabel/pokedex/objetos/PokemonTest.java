package com.isabel.pokedex.objetos;

public class PokemonTest {
	public static void main(String[] args) {
		Pokedex pokedex = new Pokedex();

//      creamos un pokemon y agregamos a la pokedex
		Pokemon pikachu = pokedex.createPokemon("Pikachu", 100, "Electric");
		pokedex.addPokemon(pikachu);
		Pokemon charmander = pokedex.createPokemon("Charmander", 100, "Fire");
		pokedex.addPokemon(charmander);

		// Atacar a un Pokemon
		pikachu.attackPokemon(charmander);
		System.out.println(pokedex.pokemonInfo(charmander));

		// Listar todos los Pokemones en la Pokedex
		pokedex.listPokemon();
	}
}
