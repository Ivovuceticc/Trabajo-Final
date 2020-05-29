package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Entrenador implements Cloneable
{
	private String nombre;
	private ArrayList<Pokemon> listaPokemones;
	private ArrayList<Pokemon> listaPokemonesDerrotados;
	private static final int cantidadPokemones = 4;
	private static final int cantidadTipoCartas = 3;
	private static final int numeroCartasParaUso = 4;
	private ArrayList<ICarta> listaCartas;
	private int numeroCartasUsadas = 0;

	public Entrenador(String nombre)
	{
		this.nombre = nombre;
		this.listaPokemones = new ArrayList<Pokemon>(Entrenador.cantidadPokemones);
		this.listaCartas = new ArrayList<ICarta>(Entrenador.cantidadTipoCartas);
		this.listaPokemonesDerrotados = new ArrayList<Pokemon>();
	}

	public void agregaPokemon(Pokemon pokemon)
	{
		this.listaPokemones.add(pokemon);
	}

	public void agregaPokemonDerrotados(Pokemon pokemon)
	{
		this.listaPokemonesDerrotados.add(pokemon);
	}

	public void agregaCarta(ICarta carta)
	{
		this.listaCartas.add(carta);
	}

	public ArrayList<Pokemon> getListaPokemones()
	{
		return listaPokemones;
	}

	public Pokemon eligePokemon() throws NumeroNoValidoException
	{
		Pokemon pokemon = null;
		Scanner sc = new Scanner(System.in);
		int i;

		System.out.println("------------------POKEDEX------------------");
		for (i = 1; i <= this.listaPokemones.size(); i++)
			System.out.println(i + "-" + this.listaPokemones.get(i - 1).toString());
		i = sc.nextInt();
		if (i > 0 && i <= this.listaPokemones.size())
			pokemon = this.listaPokemones.get(i - 1);
		else
			throw new NumeroNoValidoException("El numero no es valido, debe ser alguno de la lista mostrada", i);

		return pokemon;
	}

	public ICarta eligeCarta() throws ExcedeCantidadHechizosException,NumeroNoValidoException 
	{
		ICarta carta = null;
		Scanner sc = new Scanner(System.in);
		int i;
		
		if(this.numeroCartasUsadas < Entrenador.numeroCartasParaUso) 
		{
			System.out.println("------------------CARTAS HECHIZO------------------");
			for(i = 1; i <= Entrenador.cantidadTipoCartas; i++)
			System.out.println(i + "-" + this.listaCartas.get(i-1).toString());
			i = sc.nextInt(); 
			if( i > 0 && i <= Entrenador.cantidadTipoCartas)
				if(this.listaCartas.get(i-1).getCantidad()>0) 
				{
					carta = this.listaCartas.get(i-1);	
				}
				else throw new NumeroNoValidoException("Se agoto la cantidad de veces que se podia usar la carta", i);
			else
				throw new NumeroNoValidoException("El numero no es valido, debe ser alguno de la lista mostrada", i);	
		}
		else
			throw new ExcedeCantidadHechizosException("Se llego al limite de cartas hechizo que se pueden usar", this.numeroCartasUsadas, Entrenador.numeroCartasParaUso);
		return carta;
	}

	public String getNombre()
	{
		return nombre;
	}
	    
}
