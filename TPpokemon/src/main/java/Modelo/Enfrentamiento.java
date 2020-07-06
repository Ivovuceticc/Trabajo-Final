package Modelo;

/**
 * @author Vucetic Ivo
 * <br>
 *Clase que representa un enfrentamiento, por lo tanto contiene a dos entrenadores, la arena en la cual van a batallar, el numero del enfrentamiento
 *ya que se van a dar varios durante la ronda y cual sera el ganador de dicho enfrentamiento.  
 */
public class Enfrentamiento extends Thread
{
	private Entrenador entrenador1, entrenador2, ganador;
	private Arena arena;
	private int numeroEnfrentamiento;

	/**
	 * Constructor con cuatro parámetros para setear los dos entrenadores, la arena y el numero del enfrentamiento.<br>
	 * @param entrenador1: parámetro de tipo Entrenador que representa uno de los entrenadores a batallar.<br>
	 * @param entrenador2: parámetro de tipo Entrenador que representa al otro entrenador que batallará.<br>
	 * @param arena: parámetro de tipo Arena que representa la arena en cual se dará el encuentro.<br>
	 * @param numeroEnfrentamiento: parámetro de tipo int para asignar cual es cardinalidad a los enfrentamientos.<br>
	 */
	public Enfrentamiento(Entrenador entrenador1, Entrenador entrenador2, Arena arena, int numeroEnfrentamiento)
	{
		this.entrenador1 = entrenador1;
		this.entrenador2 = entrenador2;
		this.arena = arena;
		this.numeroEnfrentamiento = numeroEnfrentamiento;
	}

	/**
	 *Método que ejecutará el hilo y tratará de ingresar a la arena asignada. Se dará una pausa que representa el tiempo que les demorará batallar.
	 */
	@Override
	public void run()
	{
		arena.ingresarArena(this);
		SimulaPausa.espera();
		System.out.println("\nFinaliza el enfrentamiento "+ this.numeroEnfrentamiento);
	}

	@Override
	public String toString()
	{
		return "Enfrentamiento [entrenador1=" + entrenador1.getNombre() + ", entrenador2=" + entrenador2.getNombre()
				+ ", arena=" + arena.getNombre() + ", numeroEnfrentamiento=" + numeroEnfrentamiento + "]";
	}

	public Entrenador getEntrenador1()
	{
		return entrenador1;
	}

	public Entrenador getEntrenador2()
	{
		return entrenador2;
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
