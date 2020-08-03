package Modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import Persistencia.GestionPersistencia;

/**
 * @author Vucetic Ivo Clase que representa una ronda, en dicha ronda se
 *         ejecutarán los enfrentamientos correspondientes a la cantidad de
 *         entrenadores que halla.
 */
public class Ronda extends Observable implements Observer
{
	private ArrayList<Entrenador> listaGanadores;
	private ArrayList<Observable> listaObservados;
	private GestionPersistencia gestionPersistencia;
	private int totalEnfrentamientos, numeroRonda;

	public Ronda(int numero)
	{	
		this.numeroRonda = numero;
		this.listaGanadores = new ArrayList<Entrenador>();
		this.gestionPersistencia = new GestionPersistencia();
		this.listaObservados = new ArrayList<Observable>();
	}

	/**
	 * Método que dará comienzo a la ronda. Cuenta con una lista de los entrenadores
	 * que formarán parte de la misma y una lista de las arenas que podrán utilizar
	 * para realizar las batallas. Primero se establecerán los enfrentamientos,
	 * agrupando a los entrenadores de dos en dos de forma aleatoria hasta que todos
	 * queden con un rival. Dichos enfrentamientos podrán utilizar una de las arenas
	 * disponibles en el torneo, también de forma aleatoria. Luego se ejecutarán de
	 * forma concurrente los enfrentamientos. Finalizados los enfrentamientos se
	 * tomarán los ganadores de los mismos y se dará por terminada la ronda.<br>
	 * <b>Pre:</b> La lista de entrenadoresRonda debe ser distinta de null y debe
	 * estar previamente inicilizada. De la misma manera debe estár la lista de las
	 * arenas.<br>
	 * <b>Post:</b>Se devolverá una lista con los entrenadores victoriosos de la
	 * ronda.<br>
	 * 
	 * @param entrenadoresRonda: Parámetro de tipo ArrayList<Entrenador> que
	 *                           representa los entrenadores que participarán en la
	 *                           ronda.<br>
	 * @param arenas:            Parámetro de tipo ArrayList<Arena> que representa
	 *                           las arenas que se podrán utilizar en la ronda.<br>
	 * @return ArrayList<Entrenador> con los entrenadores que ganaron cada
	 *         enfrentamiento.<br>
	 */
	public void inicia(ArrayList<Entrenador> entrenadoresRonda, ArrayList<Arena> arenas)
	{
		Entrenador entrenadorA, entrenadorB;
		Random generador = new Random();
		int posRandom, numeroEnfrent = 0, cantidadEntrenadores = entrenadoresRonda.size();

		this.totalEnfrentamientos = cantidadEntrenadores / 2;
		while (cantidadEntrenadores > 0)
		{
			posRandom = generador.nextInt(cantidadEntrenadores);
			entrenadorA = entrenadoresRonda.get(posRandom);
			entrenadoresRonda.remove(posRandom);
			posRandom = generador.nextInt(cantidadEntrenadores - 1);
			entrenadorB = entrenadoresRonda.get(posRandom);
			entrenadoresRonda.remove(posRandom);

			Enfrentamiento enfrentamiento = new Enfrentamiento(entrenadorA, entrenadorB,
					arenas.get(generador.nextInt(arenas.size())), ++numeroEnfrent);
			enfrentamiento.addObserver(this);
			this.listaObservados.add(enfrentamiento);

			Thread hiloEnfrentamiento = new Thread(enfrentamiento);
			hiloEnfrentamiento.start();

			cantidadEntrenadores = entrenadoresRonda.size();
		}

	}

	@Override
	public synchronized void update(Observable observable, Object arg)
	{
		if (!this.listaObservados.contains(observable))
			throw new IllegalArgumentException();
		else
		{
			this.listaGanadores.add((Entrenador) arg);
			if (--this.totalEnfrentamientos == 0)
			{	
				this.gestionPersistencia.escribeInformacion(Util.cambiaNombreArchivo("Ronda"+ ++numeroRonda), this.listaGanadores);
				this.setChanged();
				this.notifyObservers("FIN RONDA");
			}

		}
		notifyAll();
	}

}
