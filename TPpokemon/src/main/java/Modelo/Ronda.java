package Modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * @author Vucetic Ivo Clase que representa una ronda, en dicha ronda se
 *         ejecutar�n los enfrentamientos correspondientes a la cantidad de
 *         entrenadores que halla.
 */
public class Ronda
{

	public Ronda()
	{

	}

	/**
	 * M�todo que dar� comienzo a la ronda. Cuenta con una lista de los entrenadores
	 * que formar�n parte de la misma y una lista de las arenas que podr�n utilizar
	 * para realizar las batallas. Primero se establecer�n los enfrentamientos,
	 * agrupando a los entrenadores de dos en dos de forma aleatoria hasta que todos
	 * queden con un rival. Dichos enfrentamientos podr�n utilizar una de las arenas
	 * disponibles en el torneo, tambi�n de forma aleatoria. Luego se ejecutar�n de
	 * forma concurrente los enfrentamientos. Finalizados los enfrentamientos se
	 * tomar�n los ganadores de los mismos y se dar� por terminada la ronda.<br>
	 * <b>Pre:</b> La lista de entrenadoresRonda debe ser distinta de null y debe estar previamente inicilizada. De la misma manera debe est�r la lista de las arenas.<br>
	 * <b>Post:</b>Se devolver� una lista con los entrenadores victoriosos de la ronda.<br>
	 * @param entrenadoresRonda: Par�metro de tipo ArrayList<Entrenador> que representa los entrenadores que participar�n en la ronda.<br>
	 * @param arenas: Par�metro de tipo ArrayList<Arena> que representa las arenas que se podr�n utilizar en la ronda.<br>
	 * @return ArrayList<Entrenador> con los entrenadores que ganaron cada enfrentamiento.<br>
	 */
	public ArrayList<Entrenador> inicia(ArrayList<Entrenador> entrenadoresRonda, ArrayList<Arena> arenas)
	{
		ArrayList<Entrenador> auxList = new ArrayList<Entrenador>();
		Entrenador entrenadorA, entrenadorB;
		Random generador = new Random();
		int posRandom, cantidadEntrenadores = entrenadoresRonda.size(), numeroEnfrent = -1;
		Enfrentamiento[] enfrentamientos = new Enfrentamiento[cantidadEntrenadores / 2];

		while (cantidadEntrenadores > 0)
		{
			posRandom = generador.nextInt(cantidadEntrenadores);
			entrenadorA = entrenadoresRonda.get(posRandom);
			entrenadoresRonda.remove(posRandom);
			posRandom = generador.nextInt(cantidadEntrenadores - 1);
			entrenadorB = entrenadoresRonda.get(posRandom);
			entrenadoresRonda.remove(posRandom);
			enfrentamientos[++numeroEnfrent] = new Enfrentamiento(entrenadorA, entrenadorB,
					arenas.get(generador.nextInt(arenas.size())), numeroEnfrent);

			cantidadEntrenadores = entrenadoresRonda.size();
		}

		for (int i = 0; i <= numeroEnfrent; i++)
			enfrentamientos[i].start();

		try
		{
			Thread.sleep(SimulaPausa.getEsperamax());
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		for (int j = 0; j <= numeroEnfrent; j++)
			auxList.add(enfrentamientos[j].getGanador());

		return auxList;
	}

}
