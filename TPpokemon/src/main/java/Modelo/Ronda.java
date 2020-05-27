package Modelo;

import java.util.ArrayList;
import java.util.Random;

public class Ronda
{
	private Batalla batalla;

	public Ronda()
	{
		this.batalla = new Batalla();
	}

	public ArrayList<Entrenador> inicia(ArrayList<Entrenador> entrenadoresRonda)
	{
		ArrayList<Entrenador> auxList = new ArrayList<Entrenador>();
		Entrenador entrenadorA, entrenadorB;
		Random generador = new Random();
		int posRandom,cantidadEntrenadores = entrenadoresRonda.size(); 
		
		while (cantidadEntrenadores> 0)
		{	
			posRandom = generador.nextInt(cantidadEntrenadores-1);
			entrenadorA = entrenadoresRonda.get(posRandom);
			entrenadoresRonda.remove(posRandom);
			posRandom = generador.nextInt(cantidadEntrenadores-2);
			entrenadorB = entrenadoresRonda.get(posRandom);
			entrenadoresRonda.remove(posRandom);
			
			auxList.add(batalla.inicia(entrenadorA,entrenadorB));
			cantidadEntrenadores = entrenadoresRonda.size();
		}
		return auxList;
	}
}
