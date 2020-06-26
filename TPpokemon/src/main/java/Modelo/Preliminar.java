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
		
		System.out.println("-----Entrenador: " + entrenadorB.getNombre() + "-----");
		try
		{
			pokemonB = entrenadorB.eligePokemon();
		} catch (NumeroNoValidoException e)
		{
			e.getMessage();
			pokemonB = entrenadorB.getListaPokemones().get(0);
		}
		
		this.arena.setEstado(new Batalla(entrenadorA, entrenadorB, pokemonA, pokemonB, arena));
	}

	@Override
	public void comenzarBatalla()
	{
		throw new IllegalStateException("Para poder batallar primero se deben presentar los rivales");
	}

	@Override
	public void obtenerResultados()
	{
		throw new IllegalStateException("Los resultados estarán disponible luego de batallar");
		
	}
	
	
}
