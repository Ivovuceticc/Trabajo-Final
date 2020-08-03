package Modelo;

public final class Util
{
	public static String cambiaNombreArchivo(String nombre)
	{	
		String respuesta = "";
		
		switch(nombre) {
		 case "Ronda0": respuesta = "Inscripcion.bin";
		 				break;	
		 case "Ronda1": respuesta = "OctavosDeFinal.bin";
		 				break;
		 case "Ronda2": respuesta = "CuartosDeFinal.bin";
		 				break;
		 case "Ronda3": respuesta = "Semifinal.bin";
		 				break;
		}
		return respuesta;
	}
}
