package Modelo;

public class Definicion implements IState
{
	private Arena arena;
	private Entrenador entrenadorA, entrenadorB;
	private Pokemon pokemonA, pokemonB;
	
	public Definicion(Arena arena, Entrenador entrenadorA, Entrenador entrenadorB, Pokemon pokemonA, Pokemon pokemonB)
	{
		this.arena = arena;
		this.entrenadorA = entrenadorA;
		this.entrenadorB = entrenadorB;
		this.pokemonA = pokemonA;
		this.pokemonB = pokemonB;
	}

	@Override
	public void presentarRivales(Entrenador entrenador1, Entrenador entrenador2)
	{
		throw new IllegalStateException("Los rivales ya fueron presentados!!");
	}

	@Override
	public void comenzarBatalla()
	{
		throw new IllegalStateException("La batalla termino.");
	}

	@Override
	public void obtenerResultados()
	{
		Entrenador ganador;
		double puntajeA, puntajeB;

		puntajeA = pokemonA.vitalidad + pokemonA.escudo + pokemonA.fuerza;
		puntajeB = pokemonB.vitalidad + pokemonB.escudo + pokemonB.fuerza;

		if (pokemonA.vitalidad == 0 || puntajeB > puntajeA)
		{
			pokemonB.experiencia += 3;
			pokemonA.experiencia += 1;
			ganador = entrenadorB;
			
		} else
		{
			pokemonA.experiencia += 3;
			pokemonB.experiencia += 1;
			ganador = entrenadorA;
		}
		
		ganador.setPuntosDeBatalla(200);
		//Podra ganar el pokemon contrario
		
		this.arena.setOcupada(false);
		this.arena.notifyAll();
		
	}
	
}
