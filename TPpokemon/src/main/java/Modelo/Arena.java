package Modelo;

import java.util.Observable;

/**
 * @author Vucetic Ivo 
 * <br>
 *         Clase que representa una arena del torneo. La cual ser� el lugar
 *         donde se desate el enfrentamiento entre entrenadores. Contiene un
 *         nombre, el estado en el cual podria encontrarse, el entrenador que resulte victorioso y si se puede usar dicha arena.
 *         Esta clase podr� ser observada por otras.
 */
public class Arena extends Observable
{
	private IState estado;
	private String nombre;
	private boolean ocupada = false;
	private Entrenador ganador;

	/**
	 * Constructor con un parametro para setear el nombre de la arena. Tambi�n se inicializa el estado inicial de la arena.<br>
	 * @param nombre: par�metro de tipo String que representa el nombre de la arena.
	 */
	public Arena(String nombre)
	{
		this.nombre = nombre;
		this.estado = new Preliminar(this);
	}

	/**<br>
	 * Este m�todo ser� la puerta de entrada para que se pueda usar una arena del torneo. Se podr� ingresar solo si esta desocupada, caso contrario quien ingrese deber� esperar para su uso.<br>
	 * <b>Pre: </b> El enfrentamiento debe ser distinto de null.<b>Pre: </b> 
	 * <b>Pos: </b> Si la arena se encontraba desocupada el enfrentamiento se podr� disputar, caso contrario deber� aguardar hasta que se lo notifique.<b>Pre: </b> 
	 * @param enfrentamiento: par�metro de tipo enfrentamiento que representa el par de entrenadores que quieren ingresar a dicha arena.
	 */
	public synchronized void ingresarArena(Enfrentamiento enfrentamiento)
	{
		while (ocupada)
		{	
			try
			{	
				/*
				System.out.println("\nUn enfrentamiento quiere ingresar a la arena " + this.getNombre()
						+ "es el enfrentamiento " + enfrentamiento.toString());
						
				*/
				this.setChanged();
				this.notifyObservers(arg);
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
		this.ocupada = true;
		//System.out.println("\nIngreso en la arena " + enfrentamiento.toString());
		
		notifyAll();
		this.presentarRivales(enfrentamiento.getEntrenador1(), enfrentamiento.getEntrenador2());
		this.comenzarBatalla();
		this.obtenerResultados();
		enfrentamiento.setGanador(ganador);
	}

	/**
	 * Dependiendo del estado en el que se encuentre la arena, este m�todo variar� al querer presentar a los entrenadores junto con los pokemones que van a usar. Se informar� con claridad en cada estado documentado de la arena <br>
	 * <b>Pre: </b> Los entrenadores deben ser distinto de null.<br>
	 * <b>Pos: </b> Dependiendo del estado de la arena se proceder� a presentar a los entrenadores o informar que ya se a realizado.<br>
	 * @param entrenador1: par�metro de tipo Entrenador que representa un entrenador.<br>
	 * @param entrenador2: par�metro de tipo Entrenador que representa un entrenador.<br>
	 */
	public void presentarRivales(Entrenador entrenador1, Entrenador entrenador2)
	{
		this.estado.presentarRivales(entrenador1, entrenador2);
	}

	/**
	 * Dependiendo del estado en el que se encuentre la arena, este m�todo variar� al querer enfrentar a los entrenadores. Se informar� con claridad en cada estado documentado de la arena <br>
	 */
	public void comenzarBatalla()
	{
		this.estado.comenzarBatalla();
	}

	/**
	 * Dependiendo del estado en el que se encuentre la arena, este m�todo variar� al querer obtener el resultado del enfrentamiento.Se informar� con claridad en cada estado documentado de la arena <br>
	 */
	public void obtenerResultados()
	{
		this.estado.obtenerResultados();
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setEstado(IState estado)
	{
		this.estado = estado;
	}

	public void setOcupada(boolean ocupada)
	{
		this.ocupada = ocupada;
	}

	public Entrenador getGanador()
	{
		return ganador;
	}

	public void setGanador(Entrenador ganador)
	{
		this.ganador = ganador;
	}

}
