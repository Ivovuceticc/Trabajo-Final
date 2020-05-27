package Modelo;

public class Batalla
{
	
	public Batalla() 
	{
	}

	public Entrenador inicia(Entrenador entrenadorA, Entrenador entrenadorB)
	{
		Entrenador ganador = null;
		Pokemon pokemonA, pokemonB;
		
		try
		{
			pokemonA = entrenadorA.eligePokemon();
			pokemonB = entrenadorB.eligePokemon();
		} 
		catch (NumeroNoValidoException e)
		{
			e.getMessage();
		}
		
		
		
		return ganador;
	}
}
