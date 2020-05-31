package Prueba;

import Modelo.Pokemon;
import Modelo.PokemonFactory;
import Modelo.Torneo;

public class Main
{

	public static void main(String[] args)
	{
		Torneo torneo = Torneo.getInstance();
		torneo.setNombre("ESCUDO Y ESPADA");
		
		Pokemon pokemonA1 = PokemonFactory.getPokemon("Arcanine", "Comun", "Fuego");
		Pokemon pokemonA2 = PokemonFactory.getPokemon("Steelix", "Comun", "Roca");
		Pokemon pokemonA3 = PokemonFactory.getPokemon("Lumineon", "Comun", "Agua");
		Pokemon pokemonA4 = PokemonFactory.getPokemon("Wigglytuff", "Comun", "Hada");
		
		Pokemon pokemonB1 = PokemonFactory.getPokemon("Starmie", "Comun", "Agua");
		Pokemon pokemonB2 = PokemonFactory.getPokemon("Roselia", "Comun", "Tierra");
		Pokemon pokemonB3 = PokemonFactory.getPokemon("Pupitar", "Comun", null);
		Pokemon pokemonB4 = PokemonFactory.getPokemon("Aggron", "Legendario", "Fuego");
		
		Pokemon pokemonC1 = PokemonFactory.getPokemon("Gengar", "Comun", "Hada");
		Pokemon pokemonC2 = PokemonFactory.getPokemon("Heracross", "Legendario", "Agua");
		Pokemon pokemonC3 = PokemonFactory.getPokemon("Metagross", "Comun", "Hielo");
		Pokemon pokemonC4 = PokemonFactory.getPokemon("Golem", "Comun", "Tierra");
		
		System.out.println(pokemonC1);
		System.out.println(pokemonC2);
		System.out.println(pokemonC3);
		System.out.println(pokemonC4);
		System.out.println(pokemonB4);
		System.out.println(pokemonA1);
		System.out.println(pokemonA2);
		System.out.println(pokemonB3);
		
		
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("------BIENVENIDOS AL TORNEO POKEMON DE "+ torneo.getNombre());
		System.out.println("--------------------------------------------------------------");
		
		

	}

}
