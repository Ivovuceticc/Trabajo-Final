package Modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Ronda implements Observer
{

	public Ronda()
	{

	}

	public void inicia(ArrayList<Entrenador> entrenadoresRonda, ArrayList<Arena> arenas)
	{
		ArrayList<Entrenador> auxList = new ArrayList<Entrenador>();
		Entrenador entrenadorA, entrenadorB;
		Random generador = new Random();
		int posRandom,cantidadEntrenadores = entrenadoresRonda.size(), numeroEnfrent = -1;
		Enfrentamiento[] enfrentamientos = new Enfrentamiento[cantidadEntrenadores/2]; 
		
		while (cantidadEntrenadores> 0)
		{	
			posRandom = generador.nextInt(cantidadEntrenadores);
			entrenadorA = entrenadoresRonda.get(posRandom);
			entrenadoresRonda.remove(posRandom);
			posRandom = generador.nextInt(cantidadEntrenadores-1);
			entrenadorB = entrenadoresRonda.get(posRandom);
			entrenadoresRonda.remove(posRandom);
			enfrentamientos[++numeroEnfrent] = new Enfrentamiento(entrenadorA, entrenadorB, arenas.get(generador.nextInt(2)), numeroEnfrent);
			
			cantidadEntrenadores = entrenadoresRonda.size();
		}
		
		for(int i = 0; i <= numeroEnfrent; i++)
			enfrentamientos[i].start();
			
	}

	@Override
	public void update(Observable o, Object arg)
	{
		// TODO Auto-generated method stub
		
	}
}
