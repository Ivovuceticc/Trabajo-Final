package Persistencia;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import Modelo.Entrenador;
import Modelo.Torneo;

/**
 * @author Vucetic Ivo
 * Clase que se encarga de administrar la persitencia del torneo.
 *
 */
public class GestionPersistencia
{	
			
	public GestionPersistencia()
	{
	}

	/**
	 * El método se encargará de recuperar la información de un arhivo .bin y devolver la información contenida en el.
	 * @param nombreArchivo: Parametro de tipo String representa el nombre del archivo del cual se recuperará la información.
	 * @return De tipo ArrayList<Entrenador> será la lista de los entrenadores que todavia continuen en el torneo.
	 */
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

	/**
	 * Este método se encarga de poder persistir la información en un determinado archivo.
	 * @param nombreArchivo: Parametro de tipo String representa el nombre del archivo del cual se querrá persistir la información.
	 * @param participantesActual: De tipo ArrayList<Entrenador> será la lista de los entrenadores que se guardará para luego utilizar.
	 */
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
