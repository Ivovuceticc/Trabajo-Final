package Persistencia;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import Modelo.Entrenador;
import Modelo.Torneo;

public class GestionPersistencia
{	
			
	public GestionPersistencia()
	{
	}

	public ArrayList<Entrenador> recuperaInformacion(String nombreArchivo)
	{
		IPersistencia<Serializable> persistenciaBin = new PersistenciaBin();
		ArrayList<Entrenador> participantes = null;
		try
		{
			persistenciaBin.abrirInput(nombreArchivo);
			//System.out.println("Se abre archivo"+ nombreArchivo);
			participantes = (ArrayList<Entrenador>) persistenciaBin.leer();
			//System.out.println("Se lee informacion del archivo" + nombreArchivo);
			persistenciaBin.cerrarInput();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return participantes;
	}

	public void escribeInformacion(String nombreArchivo, ArrayList<Entrenador> participantesActual)
	{
		IPersistencia<Serializable> persistenciaBin = new PersistenciaBin();
		try
		{
			persistenciaBin.abrirOutput(nombreArchivo);
			//System.out.println("Se creo el archivo");
			persistenciaBin.escribir(participantesActual);
			persistenciaBin.cerrarOutput();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
