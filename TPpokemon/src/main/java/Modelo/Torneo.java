package Modelo;

import java.util.ArrayList;

/**
 * @author Ivo Vucetic<br>
 * 
 *         Esta clase representa el funcionamiento de un torneo eliminatorio
 *         para 8 competidores. Cuenta con el conjunto de entrenadores que
 *         participaran en dicho torneo, el nombre del torneo, una variable que
 *         hara referencia a una sola instancia del torneo y una lista con las
 *         rondas del mismo.
 */
public class Torneo
{
	private String nombre;
	private ArrayList<Entrenador> listaEntrenadores;
	private final int cantidadEntrenadores;
	private static Torneo instanceTorneo = null;
	private Ronda ronda;

	/**
	 * Constructor para iniciar la lista que contendra a los entrenadores y las
	 * rondas. <br>
	 */
	private Torneo()
	{	
		this.cantidadEntrenadores = 8;
		this.listaEntrenadores = new ArrayList<Entrenador>(cantidadEntrenadores);
		this.ronda = new Ronda();
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

	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	/**
	 * Estem método se encarga de agregar un entrenador a la lista de los mismos.
	 * <br>
	 */
	public void agregaEntrenador(Entrenador entrenador)
	{
		this.listaEntrenadores.add(entrenador);
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
			listaEntrenadores = ronda.inicia(listaEntrenadores);
		}
	}

}
