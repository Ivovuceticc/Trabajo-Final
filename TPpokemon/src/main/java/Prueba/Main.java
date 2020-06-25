package Prueba;

import Controlador.Controlador;
import Modelo.DecoratorFuego;
import Modelo.Entrenador;
import Modelo.Pokemon;
import Modelo.PokemonFactory;

public class Main
{

	public static void main(String[] args)
	{	
		/*
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
		
		*/
		Controlador controlador = new Controlador();
		/*
		//Ejemplo clonar un pokemon que si admita clonacion.
		System.out.println("Zona clonacion pokemon\n");
		System.out.println("\n1-Ejemplo de que se clonan correctamente los que admiten clonacion\n");
		
		Pokemon pokemon = PokemonFactory.getPokemon("Steelix", "Comun", "Fuego");
		Pokemon pokemon2 = null;
		try
		{
			 pokemon2 = (Pokemon)pokemon.clone();
		} 
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		//Se muestran que se clonaron correctamente.
		System.out.println("\n---Se muestra que se clonaron correctamente.---\n");
		System.out.println(pokemon.toString());
		System.out.println(pokemon2.toString());
		
		//Se muestra que la clonacion profunda es correcta tambien, se modifica la variable escudo del encapsulado del clon.
		System.out.println("\n---Tambien se verifica la clonación profunda---\n");
		DecoratorFuego pokemon3 = (DecoratorFuego)pokemon2;
		pokemon3.getEncapsulado().setEscudo(50);
		System.out.println(pokemon.toString());
		System.out.println(pokemon3.toString());
		
		//Ejemplo clonacion de un pokemon que no admita clonacion.
		System.out.println("\n2-Ejemplo de que algunos no admiten clonacion\n");
		Pokemon pokemon4 = PokemonFactory.getPokemon("Pinsir", "Legendario", "Hielo");
		System.out.println(pokemon4.toString());
		Pokemon pokemon5 = null;
	
		try
		{
			 pokemon5 = (Pokemon)pokemon4.clone();
		} 
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
			
		//Ejemplo de clonacion para entrenadores, caso en que no se pueda clonar.
		
		System.out.println("\nZona clonacion entrenador\n");
		System.out.println("1-Ejemplo de un entrenador que se puede clonar\n");
		
		
		Entrenador entrenador1 = new Entrenador("Lucia");
		
		entrenador1.agregaPokemon(PokemonFactory.getPokemon("Starmie", "Comun", "Roca"));
		entrenador1.agregaPokemon(PokemonFactory.getPokemon("Roselia", "Comun", "Fuego"));
		entrenador1.agregaPokemon(PokemonFactory.getPokemon("Pupitar", "Comun", "Hada"));
		
		Entrenador entrenadorClon = null;
		
		try
		{
			entrenadorClon = (Entrenador)entrenador1.clone();
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		} 
		
		int tamaño = entrenador1.getListaPokemones().size();
		for(int i=0; i < tamano; i++)
		
		
		
		
		Entrenador entrenador1 = new Entrenador("Lucas"); 
		
		entrenador1.agregaPokemon(PokemonFactory.getPokemon("Metagross", "Comun", "Hielo"));
		entrenador1.agregaPokemon(PokemonFactory.getPokemon("Gendar", "Comun", "Agua"));
		entrenador1.agregaPokemon(PokemonFactory.getPokemon("Golem", "Legendario", "Roca"));
		
		Entrenador entrenadorClon = null;
		
		try
		{
			entrenadorClon = (Entrenador) entrenador1.clone();
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		
	*/
	}
	
}
