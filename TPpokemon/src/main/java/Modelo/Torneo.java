package Modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Persistencia.GestionPersistencia;

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

	private ArrayList<Observable> listaObservados;
	private ArrayList<Entrenador> listaEntrenadores;
	private ArrayList<Entrenador> listaEntrenadoresActual;
	private final int cantidadEntrenadores;
	private final int cantidadArenas;
	private static Torneo instanceTorneo = null;
	private ArrayList<Arena> listaArenas;
	private GestionPersistencia gestionPersistencia;
	private int rondaActual;
	private Entrenador ganador;
	private String mensajeArena;

	/**
	 * <br>
	 * Constructor sin parámetros que va a inicializar la cantidad de entrenadores
	 * que habrá en el torneo, cantidad de arenas, lista de entrenadores, lista de
	 * arenas, creará una instancia de la ronda y de las arenas que va a tener el
	 * torneo.
	 */
	private Torneo()
	{
		this.cantidadEntrenadores = 8;
		this.cantidadArenas = 3;
		this.listaEntrenadores = new ArrayList<Entrenador>(cantidadEntrenadores);
		this.listaArenas = new ArrayList<Arena>(cantidadArenas);
		this.listaEntrenadoresActual = new ArrayList<Entrenador>();
		this.listaObservados = new ArrayList<Observable>();
		this.gestionPersistencia = new GestionPersistencia();
		this.agregaArena(new Arena("Oeste"));
		this.agregaArena(new Arena("Central"));
		this.agregaArena(new Arena("Este"));
	}

	/**
	 * <br>
	 * Agrega una arena a la lista de arenas del torneo e incluye al torneo como un
	 * nuevo observador. <b>Pre:</b> arena debe ser distinto de null y debe estar
	 * previamente inicializada la lista. <b>Post:</b> Se agrega una nueva arena a
	 * la lista.
	 * 
	 * @param arena: parámetro de tipo Arena que representa una nueva arena.
	 */
	public void agregaArena(Arena arena)
	{
		this.listaArenas.add(arena);
		arena.addObserver(this);
		this.listaObservados.add(arena);
	}

	/**
	 * <br>
	 * Genera una única instancia de Torneo o devuelve la que ya esta creada.
	 * 
	 * @return Una instancia de la clase Torneo.
	 */
	public static Torneo getInstance()
	{
		if (Torneo.instanceTorneo == null)
			Torneo.instanceTorneo = new Torneo();
		return instanceTorneo;
	}

	/**
	 * <br>
	 * Agrega un entrenador al torneo. <b>Pre:</b> El entrenador debe ser distinto
	 * de null y debe estar previamente inicializada la lista. <b>Post:</b> Se
	 * agrega un entrenador al torneo.
	 * 
	 * @param entrenador: parámetro de tipo Entrenador que representa a un nuevo
	 *                    entrenador que se sumará al torneo.
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

	public void setListaEntrenadores(ArrayList<Entrenador> listaEntrenadores)
	{
		this.listaEntrenadores = listaEntrenadores;
	}

	public ArrayList<Arena> getListaArenas()
	{
		return listaArenas;
	}

	public GestionPersistencia getGestionPersistencia()
	{
		return gestionPersistencia;
	}

	public ArrayList<Entrenador> getListaEntrenadoresActual()
	{
		return listaEntrenadoresActual;
	}

	public void setListaEntrenadoresActuales(ArrayList<Entrenador> listaEntrenadoresActual)
	{
		this.listaEntrenadoresActual = listaEntrenadoresActual;
	}

	public int getRondaActual()
	{
		return rondaActual;
	}

	public Entrenador getGanador()
	{
		return ganador;
	}

	public String getMensajeArena()
	{
		return mensajeArena;
	}

	public void notificaCambios(String mensaje)
	{
		this.setChanged();
		this.notifyObservers(mensaje);
	}

	/**
	 * Este método será el encargado de lanzar el torneo. Utilizando la lista de los
	 * entrenadores se actualizará a medida que pasen las rondas, quedándose con el
	 * ganador el torneo.
	 */
	public void iniciaTorneo()
	{
		this.rondaActual = 0;
		this.listaEntrenadores = this.gestionPersistencia
				.recuperaInformacion(Util.cambiaNombreArchivo("Ronda" + rondaActual));
		this.listaEntrenadoresActual = listaEntrenadores;

		// System.out.println("Ronda numero " + numeroRonda);
		this.notificaCambios("INICIA TORNEO");
		this.comienzaRonda();

		// this.gestionPersistencia.escribeInformacion(Util.cambiaNombreArchivo("Ronda"
		// System.out.println("\n********EL GANADOR DEL TORNEO ES:" +
		// listaEntrenadores.get(0).toString() + "********");
	}

	public void comienzaRonda()
	{
		Ronda ronda = new Ronda(this.rondaActual);
		ronda.addObserver(this);
		this.listaObservados.add(ronda);

		this.notificaCambios("COMIENZA RONDA");
		ronda.inicia(this.listaEntrenadoresActual, this.listaArenas);
	}

	public void iniciaJornada()
	{
		this.listaEntrenadoresActual = this.gestionPersistencia
				.recuperaInformacion(Util.cambiaNombreArchivo("Ronda" + ++rondaActual));
		if (this.listaEntrenadoresActual.size() == 1)
		{
			this.ganador = this.listaEntrenadoresActual.get(0);
			this.notificaCambios("FIN TORNEO");
		} else
		{
			this.comienzaRonda();
		}

	}

	@Override
	public synchronized void update(Observable observable, Object arg1)
	{
		if (!this.listaObservados.contains(observable))
			throw new IllegalArgumentException();
		else if (observable.getClass().getName().equalsIgnoreCase("Modelo.Ronda"))
		{
			this.notificaCambios(arg1.toString());
			SimulaPausa.espera();
			this.iniciaJornada();
		} else if (observable.getClass().getName().equalsIgnoreCase("Modelo.Arena")
				&& ((Arena) observable).getNombre().equalsIgnoreCase("Oeste"))
		{
			this.mensajeArena = arg1.toString();
			this.notificaCambios("AVISO OESTE");
		} else if (observable.getClass().getName().equalsIgnoreCase("Modelo.Arena")
				&& ((Arena) observable).getNombre().equalsIgnoreCase("Este"))
		{
			this.mensajeArena = arg1.toString();
			this.notificaCambios("AVISO ESTE");
		} else if (observable.getClass().getName().equalsIgnoreCase("Modelo.Arena")
				&& ((Arena) observable).getNombre().equalsIgnoreCase("Central"))
		{
			this.mensajeArena = arg1.toString();
			this.notificaCambios("AVISO CENTRAL");
		}
		notifyAll();
	}

}
