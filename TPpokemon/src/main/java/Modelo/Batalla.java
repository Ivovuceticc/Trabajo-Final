package Modelo;

import java.util.Random;

/**
 * @author Vucetic Ivo<br>
 *Esta clase representa el estado en el que los entrenadores van a batallar. Cuenta con una referencia a la arena que se esta utilizando, los entrenadores y sus respectivos pokemones.<br> 
 */
public class Batalla implements IState
{	
	private Arena arena;
	private Entrenador entrenadorA, entrenadorB;
	private Pokemon pokemonA, pokemonB;

	/**
	 * Constructor con cinco parámetros, dos para setear a los entrenadores, dos para setear a los pokemones y uno para setear la arena que se usará.<br>
	 * @param entrenador1: Parámetro de tipo Entrenador que representa uno de los entrenadores a enfrentarse.<br>
	 * @param entrenador2: Parámetro de tipo Entrenador que representa uno de los entrenadores a enfrentarse.<br>
	 * @param pokemon1: Parámetro de tipo Pokemon que representa al pokemon del entrenador1.<br>
	 * @param pokemon2: Parámetro de tipo Pokemon que representa al pokemon del entrenador2.<br>
	 * @param arena: Parámetro de tipo arena que representa una de las arenas que tiene el  torneo en la cual se disputara la batalla.<br>
	 */
	public Batalla(Entrenador entrenador1, Entrenador entrenador2, Pokemon pokemon1, Pokemon pokemon2, Arena arena)
	{
		this.arena = arena;
		this.entrenadorA = entrenador1;
		this.entrenadorB = entrenador2;
		this.pokemonA = pokemon1;
		this.pokemonB = pokemon2;
	}

	/**
	 *Este método arrojará una excepción del tipo IllegalStateException al querer presentar los rivales cuando el estado de la arena es Batalla. Dicha excepción nos indica que ya se realizó la presentación de los rivales.<br>
	 */
	@Override
	public void presentarRivales(Entrenador entrenador1, Entrenador entrenador2) 
	{
		throw new IllegalStateException("Ya fueron presentados los entrenadores junto con los pokemones que se enfrentaran en la batalla!!");
	}

	/**
	 *Al comenzar la batalla cada entrenador inicialmente tiene la posiblidad de elegir una carta hechizo para disminuir los atributos del pokemon rival. 
	 *Luego de forma aleatoria se procederá a elegir cual de los pokemones comenzará el ataque.
	 *Al finalizar la batalla el estado del torneo cambiará a Definición.
	 */
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

	/**
	 *Este método arrojará una excepción del tipo IllegalStateException al querer obtener los resultados de una batalla que no se ha concretado. Dicha excepción nos indica que no se han enfrentado aun .<br>
	 */
	@Override
	public void obtenerResultados()
	{	
		throw new IllegalStateException("No se pueden obtener los resultados hasta que se enfrenten!!");
	}
}
