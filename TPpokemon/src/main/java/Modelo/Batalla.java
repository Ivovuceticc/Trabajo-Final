package Modelo;

import java.util.Random;

public class Batalla
{

	public Batalla()
	{
	}

	protected Entrenador inicia(Entrenador entrenadorA, Entrenador entrenadorB)
	{
		Pokemon pokemonA = null, pokemonB = null;Random generador = new Random();
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
			System.out.println(entrenadorA.getNombre() +"realiza un hechizo de "+ cartaHechizo.toString() +" al pokemon de" + entrenadorB.getNombre());
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
		
		System.out.println("-----Entrenador: "+ entrenadorB.getNombre() +"-----");
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
			System.out.println(entrenadorB.getNombre() +"realiza un hechizo de "+ cartaHechizo.toString()+" al pokemon de" + entrenadorB.getNombre());
			cartaHechizo.hechizar(pokemonA);
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
		
		return this.defineGanador(entrenadorA, entrenadorB, pokemonA, pokemonB);
	}

	private Entrenador defineGanador(Entrenador entrenadorA, Entrenador entrenadorB, Pokemon pokemonA, Pokemon pokemonB)
	{
		Entrenador ganador;
		double puntajeA, puntajeB;
		
		puntajeA = pokemonA.vitalidad + pokemonA.escudo + pokemonA.fuerza;
		puntajeB = pokemonB.vitalidad + pokemonB.escudo + pokemonB.fuerza;
		
		if(pokemonA.vitalidad == 0 || puntajeB > puntajeA) 
		{	
			pokemonB.experiencia += 3;
			pokemonA.experiencia += 1;
			ganador = entrenadorB;
			if(pokemonA.vitalidad == 0)
				entrenadorA.getListaPokemonesDerrotados().add(pokemonA);
			else
				entrenadorA.agregaPokemon(pokemonA);
		}	
		else 
		{
			ganador = entrenadorA;
			
			
		}
		return ganador;
	}

}
