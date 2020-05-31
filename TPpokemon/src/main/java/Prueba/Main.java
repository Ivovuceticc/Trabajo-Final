package Prueba;

import Modelo.CartaNiebla;
import Modelo.CartaTormenta;
import Modelo.CartaViento;
import Modelo.Entrenador;
import Modelo.ICarta;
import Modelo.Pokemon;
import Modelo.PokemonFactory;
import Modelo.Torneo;

public class Main
{

	public static void main(String[] args)
	{
		Torneo torneo = Torneo.getInstance();
		torneo.setNombre("ESCUDO Y ESPADA");
		
		Entrenador entrenador1 = new Entrenador("Lucas");
		Entrenador entrenador2 = new Entrenador("Lucia");
		Entrenador entrenador3 = new Entrenador("Matias");
		Entrenador entrenador4 = new Entrenador("Carolina");
		Entrenador entrenador5 = new Entrenador("Pedro");
		Entrenador entrenador6 = new Entrenador("Luciana");
		Entrenador entrenador7 = new Entrenador("Pepe");
		Entrenador entrenador8 = new Entrenador("Micaela");
		
		
		entrenador1.agregaPokemon(PokemonFactory.getPokemon("Metagross", "Comun", "Hielo"));
		entrenador1.agregaPokemon(PokemonFactory.getPokemon("Gendar", "Comun", "Agua"));
		entrenador1.agregaPokemon(PokemonFactory.getPokemon("Golem", "Legendario", "Roca"));
		
		entrenador2.agregaPokemon(PokemonFactory.getPokemon("Steelix", "Comun", "Fuego"));
		entrenador2.agregaPokemon(PokemonFactory.getPokemon("Lumineon", "Comun", "Hielo"));
		entrenador2.agregaPokemon(PokemonFactory.getPokemon("Wigglytuff", "Legendario", "Hada"));
		
		entrenador3.agregaPokemon(PokemonFactory.getPokemon("Starmie", "Comun", "Roca"));
		entrenador3.agregaPokemon(PokemonFactory.getPokemon("Roselia", "Comun", "Fuego"));
		entrenador3.agregaPokemon(PokemonFactory.getPokemon("Pupitar", "Comun", "Hada"));
		
		entrenador4.agregaPokemon(PokemonFactory.getPokemon("Aggron", "Comun", "Roca"));
		entrenador4.agregaPokemon(PokemonFactory.getPokemon("Heracross", "Comun", "Fuego"));
		entrenador4.agregaPokemon(PokemonFactory.getPokemon("Machamp", "Comun", "Agua"));
		
		entrenador5.agregaPokemon(PokemonFactory.getPokemon("Pinsir", "Legendario", "Hielo"));
		entrenador5.agregaPokemon(PokemonFactory.getPokemon("Omastar", "Comun", null));
		entrenador5.agregaPokemon(PokemonFactory.getPokemon("Ninetales", "Comun", "Fuego"));
		
		entrenador6.agregaPokemon(PokemonFactory.getPokemon("Tauros", "Legendario", null));
		entrenador6.agregaPokemon(PokemonFactory.getPokemon("Solrock", "Comun", "Roca"));
		entrenador6.agregaPokemon(PokemonFactory.getPokemon("Golduck", "Comun", "Agua"));
		
		entrenador7.agregaPokemon(PokemonFactory.getPokemon("Rhydon", "Comun", "Roca"));
		entrenador7.agregaPokemon(PokemonFactory.getPokemon("Haunter", "Comun", null));
		entrenador7.agregaPokemon(PokemonFactory.getPokemon("Hitmontop", "Legendario", "Fuego"));
		
		torneo.agregaEntrenador(entrenador1);
		torneo.agregaEntrenador(entrenador2);
		torneo.agregaEntrenador(entrenador3);
		torneo.agregaEntrenador(entrenador4);
		torneo.agregaEntrenador(entrenador5);
		torneo.agregaEntrenador(entrenador6);
		torneo.agregaEntrenador(entrenador7);
		torneo.agregaEntrenador(entrenador7);
		
		
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("------BIENVENIDOS AL TORNEO POKEMON DE "+ torneo.getNombre());
		System.out.println("--------------------------------------------------------------");
		
		

	}

}
