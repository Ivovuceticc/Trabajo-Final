package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Entrenador
{
	private String nombre;
	private ArrayList<Pokemon> listaPokemones;
	private static final int cantidadPokemones = 4;
	private ArrayList<> listacartas;

	public Entrenador(String nombre)
	{
		this.nombre = nombre;
		this.listaPokemones = new ArrayList<Pokemon>(Entrenador.cantidadPokemones);
	}

	public Pokemon eligePokemon() throws NumeroNoValidoException
	{
		Pokemon pokemon = null;
		Scanner sc = new Scanner(System.in);
		int i;
		
		System.out.println("------------------POKEDEX------------------");
		for (i = 0; i <= Entrenador.cantidadPokemones; i++)
			System.out.println(i+"-"+ this.listaPokemones.get(i).toString());
		if ((i = sc.nextInt()) <= Entrenador.cantidadPokemones)
			pokemon = this.listaPokemones.get(i);
		else
			throw new NumeroNoValidoException("El numero no es valido, debe ser alguno de la lista mostrada", i);
		
		return pokemon;
	}

}
