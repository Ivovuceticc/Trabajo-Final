package Modelo;

import java.util.Random;

public class Batalla implements IState
{	
	private Arena arena;
	private Entrenador entrenadorA, entrenadorB;
	private Pokemon pokemonA, pokemonB;

	public Batalla(Entrenador entrenador1, Entrenador entrenador2, Pokemon pokemon1, Pokemon pokemon2, Arena arena)
	{
		this.arena = arena;
		this.entrenadorA = entrenador1;
		this.entrenadorB = entrenador2;
		this.pokemonA = pokemon1;
		this.pokemonB = pokemon2;
	}

	@Override
	public void presentarRivales(Entrenador entrenador1, Entrenador entrenador2)
	{
		System.out.println("Ya fueron presentados los entrenadores junto con los pokemones que se enfrentaran en la batalla!!");
	}

	@Override
	public void comenzarBatalla()
	{
		ICarta cartaHechizo;
		Random generador = new Random();
		
		try
		{
			cartaHechizo = this.entrenadorA.eligeCarta();
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
		
		if (generador.nextInt(2) == 0)
		{
			System.out.println("Comienza a atacar" + pokemonA.getNombre());
			pokemonA.atacar(pokemonB);
			System.out.println("Contrataca " + pokemonB.getNombre());
			pokemonB.atacar(pokemonA);
		} else
		{
			System.out.println("Comienza a atacar" + pokemonB.getNombre());
			pokemonA.atacar(pokemonA);
			System.out.println("Contrataca " + pokemonA.getNombre());
			pokemonB.atacar(pokemonB);
		}
		
		this.arena.setEstado(new Definicion(arena, entrenadorA, entrenadorB, pokemonA, pokemonB));	
	}

	@Override
	public void obtenerResultados()
	{
		System.out.println("No se pueden obtener los resultados hasta que se enfrenten!!");
	}
	
	
	
	
	
	
	
	/*
	protected Entrenador inicia(Entrenador entrenadorA, Entrenador entrenadorB)
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

		if (generador.nextInt(2) == 0)
		{
			System.out.println("Comienza a atacar" + pokemonA.getNombre());
			pokemonA.atacar(pokemonB);
			System.out.println("Contrataca " + pokemonB.getNombre());
			pokemonB.atacar(pokemonA);
		} else
		{
			System.out.println("Comienza a atacar" + pokemonB.getNombre());
			pokemonA.atacar(pokemonA);
			System.out.println("Contrataca " + pokemonA.getNombre());
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

		if (pokemonA.vitalidad == 0 || puntajeB > puntajeA)
		{
			pokemonB.experiencia += 3;
			pokemonA.experiencia += 1;
			ganador = entrenadorB;
			
		} else
		{
			pokemonA.experiencia += 3;
			pokemonB.experiencia += 1;
			ganador = entrenadorA;
		}
		this.obtenerPremio();	//Ver que le doy cuando gana
		return ganador;
	}

	private void obtenerPremio()
	{

	}
	
	*/
}
