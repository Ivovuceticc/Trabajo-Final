package Modelo;

import java.util.Observable;

public class Arena extends Observable
{
	private IState estado;
	private String nombre;
	private boolean ocupada = false;
	private Entrenador ganador; 

	public Arena(String nombre)
	{	
		this.nombre = nombre;
		this.estado = new Preliminar(this);
	}

	public synchronized void ingresarArena(Enfrentamiento enfrentamiento)
	{
		while (ocupada)
		{
			try
			{	
				System.out.println("Un enfrentamiento quiere ingresar a la arena "+ this.getNombre() + "es el enfrentamiento " +enfrentamiento.toString());
				wait();
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		this.ocupada = true;
		System.out.println("Ingreso en la arena "+ enfrentamiento.toString());
		this.notifyAll();
		this.presentarRivales(enfrentamiento.getEntrenador1(), enfrentamiento.getEntrenador2());
		this.comenzarBatalla();
		this.obtenerResultados();
		enfrentamiento.setGanador(ganador);
	}

	public void presentarRivales(Entrenador entrenador1, Entrenador entrenador2)
	{
		this.estado.presentarRivales(entrenador1, entrenador2);
	}

	public void comenzarBatalla()
	{
		this.estado.comenzarBatalla();
	}

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
