package Modelo;

import java.util.Observer;
import java.util.Random;

/**
 * @author Vucetic Ivo<br>
 *         Esta clase representa el estado en el que los entrenadores van a
 *         batallar. Cuenta con una referencia a la arena que se esta
 *         utilizando, los entrenadores y sus respectivos pokemones.<br>
 */
public class Batalla implements IState
{
	private Arena arena;
	private Entrenador entrenadorA, entrenadorB;
	private Pokemon pokemonA, pokemonB;

	/**
	 * Constructor con cinco parámetros, dos para setear a los entrenadores, dos
	 * para setear a los pokemones y uno para setear la arena que se usará.<br>
	 * 
	 * @param entrenador1: Parámetro de tipo Entrenador que representa uno de los
	 *                     entrenadores a enfrentarse.<br>
	 * @param entrenador2: Parámetro de tipo Entrenador que representa uno de los
	 *                     entrenadores a enfrentarse.<br>
	 * @param pokemon1:    Parámetro de tipo Pokemon que representa al pokemon del
	 *                     entrenador1.<br>
	 * @param pokemon2:    Parámetro de tipo Pokemon que representa al pokemon del
	 *                     entrenador2.<br>
	 * @param arena:       Parámetro de tipo arena que representa una de las arenas
	 *                     que tiene el torneo en la cual se disputara la
	 *                     batalla.<br>
	 */
	public Batalla(Entrenador entrenador1, Entrenador entrenador2, Pokemon pokemon1, Pokemon pokemon2, Arena arena)
	{
		this.arena = arena;
		this.entrenadorA = entrenador1;
		this.entrenadorB = entrenador2;
		this.pokemonA = pokemon1;
		this.pokemonB = pokemon2;
		//pokemonA.addObserver(this);
		//pokemonB.addObserver(this);
	}

	/**
	 * Este método arrojará una excepción del tipo IllegalStateException al querer
	 * presentar los rivales cuando el estado de la arena es Batalla. Dicha
	 * excepción nos indica que ya se realizó la presentación de los rivales.<br>
	 */
	@Override
	public void presentarRivales(Entrenador entrenador1, Entrenador entrenador2)
	{
		throw new IllegalStateException(
				"Ya fueron presentados los entrenadores junto con los pokemones que se enfrentaran en la batalla!!");
	}

	/**
	 * Al comenzar la batalla cada entrenador toma de forma aleatoria una carta
	 * hechizo para disminuir los atributos del pokemon rival. Como se toma de forma
	 * aleatoria sin que tenga la posibilidad de pasar y no tomarla, puede que se
	 * haya agotado las cartas de un tipo en particular o que no disponga de cartas
	 * para su uso, con lo cual se podrá arrojar una excepción del tipo
	 * ExcedeCantidadHechizosException. Luego de forma aleatoria se procederá a
	 * elegir cual de los pokemones comenzará el ataque. Al finalizar la batalla el
	 * estado del torneo cambiará a Definición. <b>Post:</b> Se efecturá la batalla
	 * entre los dos entrenadores.<br>
	 */
	@Override
	public void comenzarBatalla()
	{
		ICarta cartaHechizo;
		Random generador = new Random();
		int puntosUsados;
		boolean usoA = false, usoB = false;
		String mensaje;

		if (entrenadorA.getPuntosDeBatalla() > 0)
		{
			usoA = true;
			puntosUsados = generador.nextInt(entrenadorA.getPuntosDeBatalla());
			pokemonA.cambiarPuntosDeBatalla(puntosUsados);
			entrenadorA.setPuntosDeBatalla(entrenadorA.getPuntosDeBatalla() - puntosUsados);
			mensaje = "***" + entrenadorA.getNombre() + " utilizo " + puntosUsados
					+ " puntos de batalla para su pokemon\n***";
			arena.notificaCambios(mensaje);
		}

		if (entrenadorB.getPuntosDeBatalla() > 0)
		{
			puntosUsados = generador.nextInt(entrenadorB.getPuntosDeBatalla());
			pokemonB.cambiarPuntosDeBatalla(puntosUsados);
			entrenadorB.setPuntosDeBatalla(entrenadorB.getPuntosDeBatalla() - puntosUsados);
			mensaje = "***" + entrenadorB.getNombre() + " utilizo " + puntosUsados
					+ " puntos de batalla para su pokemon\n***";
			arena.notificaCambios(mensaje);
		}

		if (usoA || usoB)
		{
			mensaje = "\n-------Stats luego del uso de puntos de batalla -------\n" + this.pokemonA.toString() + "\n"
					+ this.pokemonB.toString() + "\n";
			arena.notificaCambios(mensaje);
		}

		try
		{
			cartaHechizo = this.entrenadorA.eligeCarta();
			mensaje = "****" + entrenadorA.getNombre() + " realiza un hechizo de " + cartaHechizo.getNombre()
					+ " al pokemon de " + entrenadorB.getNombre() + "****\n";
			arena.notificaCambios(mensaje);

			cartaHechizo.hechizar(pokemonB);
		} catch (ExcedeCantidadHechizosException e)
		{
			e.getMessage();
		}
		try
		{
			cartaHechizo = entrenadorB.eligeCarta();
			mensaje = "****" + entrenadorB.getNombre() + " realiza un hechizo de " + cartaHechizo.getNombre()
					+ " al pokemon de " + entrenadorA.getNombre() + "****\n";
			arena.notificaCambios(mensaje);

			cartaHechizo.hechizar(pokemonA);
		} catch (ExcedeCantidadHechizosException e)
		{
			e.getMessage();
		}
		mensaje = "-------Stats luego de los hechizos-------\n" + this.pokemonA.toString() + "\n"
				+ this.pokemonB.toString() + "\n";
		arena.notificaCambios(mensaje);

		if (generador.nextInt(2) == 0)
		{
			mensaje = "Comienza a atacar " + pokemonA.getNombre() + "!!!";
			arena.notificaCambios(mensaje);

			pokemonA.atacar(pokemonB);
			mensaje = "\n****Realiza el contrataque " + pokemonB.getNombre() +"\n";
			arena.notificaCambios(mensaje);

			pokemonB.atacar(pokemonA);
		} else
		{
			mensaje = "Comienza a atacar " + pokemonB.getNombre() + "!!!";
			arena.notificaCambios(mensaje);

			pokemonA.atacar(pokemonA);
			mensaje = "\n****Realiza el contrataque " + pokemonA.getNombre()+ "\n";
			arena.notificaCambios(mensaje);

			pokemonB.atacar(pokemonB);
		}

		this.arena.setEstado(new Definicion(arena, entrenadorA, entrenadorB, pokemonA, pokemonB));
		
		mensaje = "Estado arena: Definición";
		arena.notificaCambios(mensaje);
	}

	/**
	 * Este método arrojará una excepción del tipo IllegalStateException al querer
	 * obtener los resultados de una batalla que no se ha concretado. Dicha
	 * excepción nos indica que no se han enfrentado aun .<br>
	 */
	@Override
	public void obtenerResultados()
	{
		throw new IllegalStateException("No se pueden obtener los resultados hasta que se enfrenten!!");
	}
	
	/*
	@Override
	public void update(Observable arg0, Object arg1)
	{
		if ((Pokemon) arg0 == this.pokemonA || (Pokemon) arg0 == this.pokemonB)
		{
			this.setChanged();
			this.notifyObservers((String)arg1);
		}
		else
			throw new IllegalArgumentException();
	}
	*/
}
