package Modelo;

public class Enfrentamiento extends Thread
{
	private Entrenador entrenador1, entrenador2, ganador;
	private Arena arena;
	private int numeroEnfrentamiento;

	public Enfrentamiento(Entrenador entrenador1, Entrenador entrenador2, Arena arena, int numeroEnfrentamiento)
	{
		this.entrenador1 = entrenador1;
		this.entrenador2 = entrenador2;
		this.arena = arena;
		this.numeroEnfrentamiento = numeroEnfrentamiento;
	}

	@Override
	public void run()
	{
		SimulaPausa.espera();
		arena.ingresarArena(this);
	}

	@Override
	public String toString()
	{
		return "Enfrentamiento [entrenador1=" + entrenador1.getNombre() + ", entrenador2=" + entrenador2.getNombre() + ", arena=" + arena.getNombre()
				+ ", numeroEnfrentamiento=" + numeroEnfrentamiento + "]";
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
