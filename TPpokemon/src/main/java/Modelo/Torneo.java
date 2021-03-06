package Modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Persistencia.GestionPersistencia;

/**
 * @author Vucetic Ivo <br>
 *         Clase que representa un torneo de entrenadores pokemon, esta formado
 *         por dos ArrayList, una de los entrenadores que van a participar y
 *         otra con las arenas que se van a poder utilizar en el torneo. Tambi�n
 *         por dos constantes que determinar�n la cantidad de entrenadores y
 *         arenas que habr�, una variable de instancia static que determina una
 *         �nica instancia del torneo. Cuenta tambien con una lista de los
 *         objetos que tendra que observar el torneo y una variable que se
 *         encargar� de realizar la persistencia en el programa.
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
	 * Constructor sin par�metros que va a inicializar la cantidad de entrenadores
	 * que habr� en el torneo, cantidad de arenas, lista de entrenadores, lista de
	 * arenas, lista de observados,las arenas que va a tener el torneo y el
	 * persistidor.
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
	 * Agrega una arena a la lista de arenas del torneo y a la lista de los
	 * observados e incluye al torneo como un nuevo observador. <b>Pre:</b> arena
	 * debe ser distinto de null y debe estar previamente inicializada la lista.
	 * <b>Post:</b> Se agrega una nueva arena a la lista y se suma a la lista de
	 * observados por el torneo.
	 * 
	 * @param arena: par�metro de tipo Arena que representa una nueva arena.
	 */
	public void agregaArena(Arena arena)
	{
		this.listaArenas.add(arena);
		arena.addObserver(this);
		this.listaObservados.add(arena);
	}

	/**
	 * <br>
	 * Genera una �nica instancia de Torneo o devuelve la que ya esta creada.
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
	 * @param entrenador: par�metro de tipo Entrenador que representa a un nuevo
	 *                    entrenador que se sumar� al torneo.
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
	 * Este m�todo ser� el encargado de lanzar el torneo. Lo primero que har� es
	 * tomar la informaci�n contenida en el archivo Inscripcion para luego poder
	 * iniciar la ronda correspondiente. Se notificar�n los cambios a los
	 * observadores correspondientes del torneo. <b>Pos:</b> Una vez que tengo la
	 * informaci�n necesaria se llamar� para crear la ronda.
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

	/**
	 * Se encarg� de crear la ronda y poder enviarle lo necesario para que pueda
	 * ejecutarse, se enviar� la lista de los entrenadores que quedan en el torneo
	 * junto con las arenas disponibles. Tambi�n se encargar� de agregar como
	 * observador de la ronda al torneo y se agregar� a la lista de observados del
	 * torneo.
	 * 
	 * <b>Pos:</b> Se crea la ronda y se inicia.
	 * 
	 */
	public void comienzaRonda()
	{
		Ronda ronda = new Ronda(this.rondaActual);
		ronda.addObserver(this);
		this.listaObservados.add(ronda);

		this.notificaCambios("COMIENZA RONDA");
		ronda.inicia(this.listaEntrenadoresActual, this.listaArenas);
	}

	/**
	 * Dependiendo de la cantidad de entrenadores en el torneo se decide si se
	 * comienda una nueva ronda del torneo o si se llega al ganador del mismo.
	 */
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
