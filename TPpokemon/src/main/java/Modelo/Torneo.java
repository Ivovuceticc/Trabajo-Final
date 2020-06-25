package Modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Ivo Vucetic<br>
 * 
 *         Esta clase representa el funcionamiento de un torneo eliminatorio
 *         para 8 competidores. Cuenta con el conjunto de entrenadores que
 *         participaran en dicho torneo, el nombre del torneo, una variable que
 *         hara referencia a una sola instancia del torneo y una lista con las
 *         rondas del mismo.
 */
public class Torneo extends Observable implements Observer
{
	private ArrayList<Entrenador> listaEntrenadores;
	private final int cantidadEntrenadores;
	private final int cantidadArenas;
	private static Torneo instanceTorneo = null;
	private Ronda ronda;
	private ArrayList<Arena> listaArenas;

	/**
	 * Constructor para iniciar la lista que contendra a los entrenadores y las
	 * rondas. <br>
	 */
	private Torneo()
	{
		this.cantidadEntrenadores = 8;
		this.cantidadArenas = 2;
		this.listaEntrenadores = new ArrayList<Entrenador>(cantidadEntrenadores);
		this.listaArenas = new ArrayList<Arena>(cantidadArenas);
		this.ronda = new Ronda();
		this.agregaArena(new Arena("Norte"));
		this.agregaArena(new Arena("Sur"));
	}

	public void agregaArena(Arena arena)
	{
		this.listaArenas.add(arena);
		arena.addObserver(this);
	}

	/**
	 * Este método nos devuelve una instancia única del torneo. <br>
	 * 
	 * @return Referencia de tipo Torneo
	 */
	public static Torneo getInstance()
	{
		if (Torneo.instanceTorneo == null)
			Torneo.instanceTorneo = new Torneo();
		return instanceTorneo;
	}

	/**
	 * Estem método se encarga de agregar un entrenador a la lista de los mismos.
	 * <br>
	 */
	public void agregaEntrenador(Entrenador entrenador)
	{
		this.listaEntrenadores.add(entrenador);
	}

	public int getCantidadEntrenadores()
	{
		return cantidadEntrenadores;
	}

	public ArrayList<Entrenador> getListaEntrenadores()
	{
		return listaEntrenadores;
	}

	/**
	 * Este método se encarga de crear la ronda para luego delegar el trabajo de
	 * iniciarla. <br>
	 * <b>Pre:</b> numero >= 0
	 * 
	 * @param numero: Representa la actual.
	 */
	public void iniciaTorneo()
	{
		while (listaEntrenadores.size() > 1)
		{
			ronda.inicia(listaEntrenadores, listaArenas);
		}
		// Aca voy a tener que hacer algo con el ganador
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		// El torneo va a escuchar a la arena que es el observable y el objeto sera el entrenador que gane

	}

}
