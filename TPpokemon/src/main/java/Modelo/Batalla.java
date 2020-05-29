package Modelo;

import java.util.Random;

public class Batalla
{

	public Batalla()
	{
	}

	protected Entrenador inicia(Entrenador entrenadorA, Entrenador entrenadorB)
	{
		Pokemon pokemonA, pokemonB;Random generador = new Random();
		ICarta cartaHechizo;

		System.out.println("------ELECCION DE POKEMONES------");
		
		System.out.println("-----Entrenador: "+ entrenadorA.getNombre() +"-----");
		try
		{
			pokemonA = entrenadorA.eligePokemon();
		} 
		catch (NumeroNoValidoException e)
		{
			e.getMessage();
			pokemonA = entrenadorA.getListaPokemones().get(0);
		}
		try
		{
			cartaHechizo = entrenadorA.eligeCarta();
			System.out.println(entrenadorA.getNombre() +"realiza un hechizo de "+ cartaHechizo.getString() " al pokemon de" + entrenadorB.getNombre());
			cartaHechizo.hechizar(pokemonB);
		}
		catch(ExcedeCantidadHechizosException e)
		{
			e.getMessage();
		}
		catch(NumeroNoValidoException  e)
		{
			e.getMessage();
		}
		
		System.out.println("-----Entrenador: "+ entrenadorB.getNombre() +""-----");
		try
		{
			pokemonB = entrenadorB.eligePokemon();
		} catch (NumeroNoValidoException e)
		{
			e.getMessage();
			pokemonB = entrenadorB.getListaPokemones().get(0);
		}
		try
		{
			cartaHechizo = entrenadorB.eligeCarta();
			System.out.println(entrenadorB.getNombre() +"realiza un hechizo de "+ cartaHechizo.getString()+" al pokemon de" + entrenadorB.getNombre());
			cartaHechizo.hechizar(PokemonA);
		}
		catch(ExcedeCantidadHechizosException e)
		{
			e.getMessage();
		}
		catch(NumeroNoValidoException  e)
		{
			e.getMessage();
		}
		
		if (generador.nextInt(1) == 0)
		{
			System.out.println("Comienza a atacar"+ pokemonA.getNombre());
			pokemonA.atacar(pokemonB);
			System.out.println("Contrataca "+ pokemonB.getNombre());
			pokemonB.atacar(pokemonA);
		}
		else
		{
			System.out.println("Comienza a atacar"+ pokemonB.getNombre());
			pokemonA.atacar(pokemonA);
			System.out.println("Contrataca "+ pokemonA.getNombre());
			pokemonB.atacar(pokemonB);
		}		
		
		return batalla.defineGanador(pokemonA, pokemonB, entrenadorA, entrenadorB);
	}

	private Entrenador defineGanador(Entrenador entrenadorA, Entrenador entrenadorB, Pokemon pokemonA, Pokemon pokemonB)
	{
		Entrenador ganador;
		int puntajeA, puntajeB;
		
		puntajeA = pokemonA.getVitalidad() + pokemonA.getEscudo() + pokemonA.getFuerza();
		puntajeB = pokemonB.getVitalidad() + pokemonB.getEscudo() + pokemonB.getFuerza();
		
		if(pokemonA.getVitalidad() == 0 || puntajeB > puntajeA) 
		{	
			pokemonA.setExperiencia()
			ganador = entrenadorB;
		}	
		else
			ganador = entrenadorA;
	}

}
