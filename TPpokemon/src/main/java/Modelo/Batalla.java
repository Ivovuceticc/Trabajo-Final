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
	 * Constructor con cinco par�metros, dos para setear a los entrenadores, dos para setear a los pokemones y uno para setear la arena que se usar�.<br>
	 * @param entrenador1: Par�metro de tipo Entrenador que representa uno de los entrenadores a enfrentarse.<br>
	 * @param entrenador2: Par�metro de tipo Entrenador que representa uno de los entrenadores a enfrentarse.<br>
	 * @param pokemon1: Par�metro de tipo Pokemon que representa al pokemon del entrenador1.<br>
	 * @param pokemon2: Par�metro de tipo Pokemon que representa al pokemon del entrenador2.<br>
	 * @param arena: Par�metro de tipo arena que representa una de las arenas que tiene el  torneo en la cual se disputara la batalla.<br>
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
	 *Este m�todo arrojar� una excepci�n del tipo IllegalStateException al querer presentar los rivales cuando el estado de la arena es Batalla. Dicha excepci�n nos indica que ya se realiz� la presentaci�n de los rivales.<br>
	 */
	@Override
	public void presentarRivales(Entrenador entrenador1, Entrenador entrenador2) 
	{
		throw new IllegalStateException("Ya fueron presentados los entrenadores junto con los pokemones que se enfrentaran en la batalla!!");
	}

	/**
	 *Al comenzar la batalla cada entrenador toma de forma aleatoria una carta hechizo para disminuir los atributos del pokemon rival.
	 *Como se toma de forma aleatoria sin que tenga la posibilidad de pasar y no tomarla, puede que se haya agotado las cartas de un tipo en particular
	 *o que no disponga de cartas para su uso, con lo cual se podr� arrojar una excepci�n del tipo ExcedeCantidadHechizosException.
	 *Luego de forma aleatoria se proceder� a elegir cual de los pokemones comenzar� el ataque.
	 *Al finalizar la batalla el estado del torneo cambiar� a Definici�n.
	 *<b>Post:</b> Se efectur� la batalla entre los dos entrenadores.<br>
	 */
	@Override
	public void comenzarBatalla()
	{
		ICarta cartaHechizo;
		Random generador = new Random();
		int puntosUsados; boolean usoA = false, usoB = false;
		
		if(entrenadorA.getPuntosDeBatalla() > 0) 
		{	
			usoA = true;
			puntosUsados = generador.nextInt(entrenadorA.getPuntosDeBatalla());
			pokemonA.cambiarPuntosDeBatalla(puntosUsados);
			entrenadorA.setPuntosDeBatalla(entrenadorA.getPuntosDeBatalla() - puntosUsados);
			System.out.println("***"+ entrenadorA.getNombre()+" utilizo "+ puntosUsados +" puntos de batalla para su pokemon\n***");
		}
		
		if(entrenadorB.getPuntosDeBatalla() > 0) 
		{	
			puntosUsados = generador.nextInt(entrenadorB.getPuntosDeBatalla());
			pokemonB.cambiarPuntosDeBatalla(puntosUsados);
			entrenadorB.setPuntosDeBatalla(entrenadorB.getPuntosDeBatalla() - puntosUsados);
			System.out.println("***"+ entrenadorB.getNombre()+" utilizo "+ puntosUsados +" puntos de batalla para su pokemon\n***");
		}
		
		if(usoA || usoB) 
		{
			System.out.println("\n-------Stats luego del uso de puntos de batalla -------");
			System.out.println(this.pokemonA.toString());
			System.out.println(this.pokemonB.toString() +"\n");
		}	
		
		try
		{
			cartaHechizo = this.entrenadorA.eligeCarta();
			System.out.println("****"+entrenadorA.getNombre() + " realiza un hechizo de " + cartaHechizo.getNombre()
					+ " al pokemon de " + entrenadorB.getNombre()+"****\n");
			cartaHechizo.hechizar(pokemonB);
		} catch (ExcedeCantidadHechizosException e)
		{
			e.getMessage();
		}
		try
		{
			cartaHechizo = entrenadorB.eligeCarta();
			System.out.println("****"+entrenadorB.getNombre() + " realiza un hechizo de " + cartaHechizo.getNombre()
					+ " al pokemon de " + entrenadorA.getNombre()+"****\n");
			cartaHechizo.hechizar(pokemonA);
		} catch (ExcedeCantidadHechizosException e)
		{
			e.getMessage();
		} 
		System.out.println("-------Stats luego de los hechizos-------");
		System.out.println(this.pokemonA.toString());
		System.out.println(this.pokemonB.toString() +"\n");
		
		if (generador.nextInt(2) == 0)
		{
			System.out.println("Comienza a atacar " + pokemonA.getNombre() +"!!!");
			pokemonA.atacar(pokemonB);
			System.out.println("\n****Realiza el contrataque " + pokemonB.getNombre());
			pokemonB.atacar(pokemonA);
		} else
		{
			System.out.println("Comienza a atacar " + pokemonB.getNombre() +"!!!");
			pokemonA.atacar(pokemonA);
			System.out.println("\n****Realiza el contrataque " + pokemonA.getNombre());
			pokemonB.atacar(pokemonB);
		}
		
		this.arena.setEstado(new Definicion(arena, entrenadorA, entrenadorB, pokemonA, pokemonB));	
	}

	/**
	 *Este m�todo arrojar� una excepci�n del tipo IllegalStateException al querer obtener los resultados de una batalla que no se ha concretado. Dicha excepci�n nos indica que no se han enfrentado aun .<br>
	 */
	@Override
	public void obtenerResultados()
	{	
		throw new IllegalStateException("No se pueden obtener los resultados hasta que se enfrenten!!");
	}
}
