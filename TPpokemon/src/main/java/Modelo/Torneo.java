package Modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Torneo extends Observable implements Observer
{
	private ArrayList<Entrenador> listaEntrenadores;
	private final int cantidadEntrenadores;
	private final int cantidadArenas;
	private static Torneo instanceTorneo = null;
	private Ronda ronda;
	private ArrayList<Arena> listaArenas;

	private Torneo()
	{
		this.cantidadEntrenadores = 4;
		this.cantidadArenas = 3;
		this.listaEntrenadores = new ArrayList<Entrenador>(cantidadEntrenadores);
		this.listaArenas = new ArrayList<Arena>(cantidadArenas);
		this.ronda = new Ronda();
		this.agregaArena(new Arena("Norte"));
		this.agregaArena(new Arena("Sur"));
		this.agregaArena(new Arena("Oeste"));
	}

	public void agregaArena(Arena arena)
	{
		this.listaArenas.add(arena);
		arena.addObserver(this);
	}

	public static Torneo getInstance()
	{
		if (Torneo.instanceTorneo == null)
			Torneo.instanceTorneo = new Torneo();
		return instanceTorneo;
	}

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

	public void iniciaTorneo()
	{
		while (listaEntrenadores.size() > 1)
		{
			listaEntrenadores = ronda.inicia(listaEntrenadores, listaArenas);
		}
		System.out.println("El ganador es:"+ listaEntrenadores.get(0).toString());
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
