package Modelo;

import java.util.Random;

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
		Entrenador ganador, perdedor;
		double puntajeA, puntajeB;
		Random r = new Random();

		puntajeA = pokemonA.vitalidad + pokemonA.escudo + pokemonA.fuerza;
		puntajeB = pokemonB.vitalidad + pokemonB.escudo + pokemonB.fuerza;

		if (pokemonA.vitalidad == 0 || puntajeB > puntajeA)
		{
			pokemonB.experiencia += 3;
			pokemonA.experiencia += 1;
			ganador = entrenadorB;
			perdedor = entrenadorA;
			
		} else
		{
			pokemonA.experiencia += 3;
			pokemonB.experiencia += 1;
			ganador = entrenadorA;
			perdedor = entrenadorB;
		}
		
		System.out.println("\nEl ganador de la batalla es: "+ ganador.getNombre());
		this.arena.setGanador(ganador);
		
		ganador.setPuntosDeBatalla(ganador.getPuntosDeBatalla() + 200);
		System.out.println("\nAhora podrás quedarte con uno de sus pokemones!! ademas de recibir puntos de batalla!");
		int tamaño = perdedor.getListaPokemones().size();
		int numAleatorio = r.nextInt(tamaño);
		Pokemon pokemon = perdedor.getListaPokemones().get(numAleatorio);
		perdedor.getListaPokemones().remove(numAleatorio);
		ganador.getListaPokemones().add(pokemon);
		System.out.println("\nTe has quedado con "+ pokemon+" !!!! y has ganado 200 puntos de batalla !!");
		
		if(perdedor.actualizaCategoria())
			System.out.println("\nLuego de la batalla "+ perdedor.getNombre() + " adquirió la categoria de "+ perdedor.getCategoria());
		if(ganador.actualizaCategoria())
			System.out.println("\nLuego de la batalla "+ ganador.getNombre() + " adquirió la categoria de "+ ganador.getCategoria());
		
		
		this.arena.setEstado(new Preliminar(arena));
		this.arena.setOcupada(false);
		this.arena.notifyAll();
		
	}
	
}
