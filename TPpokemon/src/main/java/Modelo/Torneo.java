package Modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Vucetic Ivo
 * <br>
 * Clase que representa un torneo de entrenadores pokemon, esta formado por dos ArrayList, una de los entrenadores que van a participar y 
 * otra con las arenas que se van a poder utilizar en el torneo. También por dos constantes que determinarán la cantidad de entrenadores y arenas que habrá,
 * una variable de instancia static que determina una única instancia del torneo y una variable de instancia de tipo Ronda que determina la ronda actual en la que estarán los entrenadores.
 * 
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
	 * <br>
	 * Constructor sin parámetros que va a inicializar la cantidad de entrenadores que habrá en el torneo, cantidad de arenas, lista de entrenadores, lista de arenas, creará una instancia de la ronda y de las arenas que va a tener el torneo. 
	 */
	private Torneo()
	{
		this.cantidadEntrenadores = 8;
		this.cantidadArenas = 3;
		this.listaEntrenadores = new ArrayList<Entrenador>(cantidadEntrenadores);
		this.listaArenas = new ArrayList<Arena>(cantidadArenas);
		this.ronda = new Ronda();
		this.agregaArena(new Arena("Norte"));
		this.agregaArena(new Arena("Sur"));
		this.agregaArena(new Arena("Oeste"));
	}

	/**
	 * <br>
	 * Agrega una arena a la lista de arenas del torneo e incluye al torneo como un nuevo observador.
	 * <b>Pre:</b> arena debe ser distinto de null y debe estar previamente inicializada la lista.
	 * <b>Post:</b> Se agrega una nueva arena a la lista.  
	 * @param arena: parámetro de tipo Arena que representa una nueva arena.
	 */
	public void agregaArena(Arena arena)
	{
		this.listaArenas.add(arena);
		arena.addObserver(this);
	}

	/**<br>
	 * Genera una única instancia de Torneo o devuelve la que ya esta creada.
	 * @return Una instancia de la clase Torneo.
	 */
	public static Torneo getInstance()
	{
		if (Torneo.instanceTorneo == null)
			Torneo.instanceTorneo = new Torneo();
		return instanceTorneo;
	}

	/**<br>
	 * Agrega un entrenador al torneo.
	 * <b>Pre:</b> El entrenador debe ser distinto de null y debe estar previamente inicializada la lista.
	 * <b>Post:</b> Se agrega un entrenador al torneo.
	 * @param entrenador: parámetro de tipo Entrenador que representa a un nuevo entrenador que se sumará al torneo.
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
	 * Este método será el encargado de lanzar el torneo. Utilizando la lista de los entrenadores se actualizará a medida que pasen las rondas, quedándose con el ganador el torneo.
	 */
	public void iniciaTorneo()
	{	
		int numeroRonda = 0;
		
		while (listaEntrenadores.size() > 1)
		{	
			System.out.println("Ronda numero "+ numeroRonda++);
			listaEntrenadores = ronda.inicia(listaEntrenadores, listaArenas);
		}
		System.out.println("\n********EL GANADOR DEL TORNEO ES:"+ listaEntrenadores.get(0).toString() +"********");
	}

	@Override
	public void update(Observable observable, Object arg1)
	{
		Arena arena = (Arena) observable;
		if (this.listaArenas.contains(arena))
		{
			System.out.println("El estado de la arena "+ arena.getNombre()+" es: "+ arg1);
		}
		else
			throw new IllegalArgumentException();
	}

}
