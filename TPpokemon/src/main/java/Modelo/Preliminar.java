package Modelo;

import java.util.Random;

public class Preliminar implements IState
{
	private Arena arena;

	public Preliminar(Arena arena)
	{
		this.arena = arena;
	}

	@Override
	public void presentarRivales(Entrenador entrenadorA, Entrenador entrenadorB)
	{
		Pokemon pokemonA = null, pokemonB = null;
		Random generador = new Random();
		ICarta cartaHechizo;

		System.out.println("------ELECCION DE POKEMONES------");

		System.out.println("-----Entrenador: " + entrenadorA.getNombre() + "-----");
		try
		{
			pokemonA = entrenadorA.eligePokemon();
		} catch (NumeroNoValidoException e)
		{
			e.getMessage();
			pokemonA = entrenadorA.getListaPokemones().get(0);
		}
		try
		{
			cartaHechizo = entrenadorA.eligeCarta();
			System.out.println(entrenadorA.getNombre() + "realiza un hechizo de " + cartaHechizo.getNombre()
					+ " al pokemon de" + entrenadorB.getNombre());
			cartaHechizo.hechizar(pokemonB);
		} catch (ExcedeCantidadHechizosException e)
		{
			e.getMessage();
		} catch (NumeroNoValidoException e)
		{
			e.getMessage();
		}

		System.out.println("-----Entrenador: " + entrenadorB.getNombre() + "-----");
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
			System.out.println(entrenadorB.getNombre() + "realiza un hechizo de " + cartaHechizo.getNombre()
					+ " al pokemon de" + entrenadorB.getNombre());
			cartaHechizo.hechizar(pokemonA);
		} catch (ExcedeCantidadHechizosException e)
		{
			e.getMessage();
		} catch (NumeroNoValidoException e)
		{
			e.getMessage();
		}
		
		this.arena.setEstado(new Batalla(entrenadorA, entrenadorB, pokemonA, pokemonB, arena));
	}

	@Override
	public void comenzarBatalla()
	{
		System.out.println("Para poder batallar primero se deben presentar los rivales");
	}

	@Override
	public void obtenerResultados()
	{
		System.out.println("Los resultados estarán disponible luego de batallar");
		
	}
	
	
}
