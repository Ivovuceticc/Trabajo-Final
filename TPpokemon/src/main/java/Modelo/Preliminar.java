package Modelo;


import java.util.Random;

/**
 * @author Vucetic Ivo
 * Esta clase representa el estado de la arena en el cual los entrenadores eligen a los pokemones que utilizar�n. Cuenta con una variable
 * de instancia que tiene la referencia al objeto que tendr� los cambios de estado. 
 */
public class Preliminar implements IState
{
	private Arena arena;

	/**
	 * Constructor con un par�metro para setear la arena.<br>
	 * @param arena: par�metro de tipo Arena que representa el lugar donde se llevar� a cabo los enfrentamientos.
	 */
	public Preliminar(Arena arena)
	{
		this.arena = arena;
	}

	/**
	 *En este m�todo los entrenadores eligen de su pokedex el pokemon con mayor poder de batalla.<br>
	 *Luego de presentados, se cambia el estado de la arena para que puedan batallar.<br>
	 *<b>Pre:</b> entrenadorA y entrenadorB deben ser distintos de null.<br>
	 *<b>Post:</b> se obtienen los pokemones que van a usar para la batalla.<br>
	 */
	@Override
	public void presentarRivales(Entrenador entrenadorA, Entrenador entrenadorB)
	{
		Pokemon pokemonA = null, pokemonB = null;
		Random generador = new Random();
		String mensaje;
			
		pokemonA = entrenadorA.eligePokemon();
		
		mensaje ="-----Entrenador: " + entrenadorA.getNombre() + " elige a "+ pokemonA + "-----"; 
		arena.notificaCambios(mensaje);
		
		pokemonB = entrenadorB.eligePokemon();

		mensaje ="-----Entrenador: " + entrenadorB.getNombre() + " elige a "+ pokemonB + "-----"; 
		arena.notificaCambios(mensaje);
		
		this.arena.setEstado(new Batalla(entrenadorA, entrenadorB, pokemonA, pokemonB, arena));
		
		mensaje = "\nEstado arena: Batalla\n";
		arena.notificaCambios(mensaje);
	}

	/**
	 *En el caso de que se quiera utilizar este m�todo en un estado diferente al Preliminar se informar� la correspontiente excepci�n.<br>
	 *@throws IllegalStateException: Cuando se quiere ejecutar este m�todo se va a informar que para poder batallar se deben presentar los rivales.
	 */
	@Override
	public void comenzarBatalla() 
	{
		throw new IllegalStateException("Para poder batallar primero se deben presentar los rivales");
	}

	/**
	 *En el caso de que se quiera utilizar este m�todo en un estado diferente al Preliminar se informar� la correspontiente excepci�n.<br>
	 *@throws IllegalStateException: Cuando se quiere ejecutar este m�todo se va a informar que se podr�n obtener los resultados luego de batallar.
	 */
	@Override
	public void obtenerResultados()
	{
		throw new IllegalStateException("Los resultados estar�n disponible luego de batallar");
		
	}
	
	
}
