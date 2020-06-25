package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Entrenador implements Cloneable, Clasificable
{
	private String nombre;
	private ArrayList<Pokemon> listaPokemones;
	private static final int cantidadPokemones = 3;
	private static final int cantidadTipoCartas = 3;
	private static final int numeroCartasParaUso = 2;
	private ArrayList<ICarta> listaCartas;
	private int numeroCartasUsadas = 0, puntosDeBatalla = 0;
	private String categoria;

	public Entrenador(String nombre)
	{
		this.nombre = nombre;
		this.listaPokemones = new ArrayList<Pokemon>(Entrenador.cantidadPokemones);
		this.listaCartas = new ArrayList<ICarta>(Entrenador.cantidadTipoCartas);
		this.listaCartas.add(new CartaNiebla());
		this.listaCartas.add(new CartaViento());
		this.listaCartas.add(new CartaTormenta());
		
	}

	public void agregaPokemon(Pokemon pokemon)
	{
		this.listaPokemones.add(pokemon);
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
		{
			pokemon = this.listaPokemones.get(i - 1);
		} else
			throw new NumeroNoValidoException("El numero no es valido, debe ser alguno de la lista mostrada", i);

		return pokemon;
	}

	public ICarta eligeCarta() throws ExcedeCantidadHechizosException, NumeroNoValidoException
	{
		ICarta carta = null;
		Scanner sc = new Scanner(System.in);
		int i;

		if (this.numeroCartasUsadas < Entrenador.numeroCartasParaUso)
		{
			System.out.println("------------------CARTAS HECHIZO------------------");
			for (i = 1; i <= Entrenador.cantidadTipoCartas; i++)
				System.out.println(i + "-" + this.listaCartas.get(i - 1).toString());
			i = sc.nextInt();
			if (i > 0 && i <= Entrenador.cantidadTipoCartas)
				if (this.listaCartas.get(i - 1).getCantidad() > 0)
				{
					carta = this.listaCartas.get(i - 1);
					carta.setCantidad(carta.getCantidad() - 1);
				} else
					throw new NumeroNoValidoException("Se agoto la cantidad de veces que se podia usar la carta", i);
			else
				throw new NumeroNoValidoException("El numero no es valido, debe ser alguno de la lista mostrada", i);
		} else
			throw new ExcedeCantidadHechizosException("Se llego al limite de cartas hechizo que se pueden usar",
					this.numeroCartasUsadas, Entrenador.numeroCartasParaUso);
		return carta;
	}

	public String getNombre()
	{
		return nombre;
	}

	public int getPuntosDeBatalla()
	{
		return puntosDeBatalla;
	}

	@Override
	public String getCategoria()
	{
		return this.categoria;
	}
	
	public static int getCantidadpokemones()
	{
		return cantidadPokemones;
	}

	@Override
	public boolean actualizaCategoria()
	{
		int experiencia = 0;
		boolean respuesta = false;
		Iterator<Pokemon> it = this.listaPokemones.iterator();
		while (it.hasNext())
		{
			Pokemon pokemon = it.next();
			experiencia += pokemon.experiencia;
		}
		if (experiencia > 0 && experiencia <= 50 && !categoria.equalsIgnoreCase("Principiante"))
		{
			respuesta = true;
			this.categoria = "Principiante";
			this.puntosDeBatalla += 400;
		} else if (experiencia > 50 && experiencia <= 100 && !categoria.equalsIgnoreCase("Intermedio"))
		{
			respuesta = true;
			this.categoria = "Intermedio";
			this.puntosDeBatalla += 800;
		} else if (experiencia > 100 && experiencia <= 150 && !categoria.equalsIgnoreCase("Avanzado"))
		{
			respuesta = true;
			this.categoria = "Avanzado";
			this.puntosDeBatalla += 1200;
		}
		return respuesta;
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		Entrenador entrenadorClone = null;
		entrenadorClone = (Entrenador) super.clone();
		if (this.listaPokemones != null && this.listaCartas != null)
		{
			entrenadorClone.listaPokemones = (ArrayList<Pokemon>) listaPokemones.clone();
			entrenadorClone.listaPokemones.clear();
			int tamano = this.listaPokemones.size();
			for (int i = 0; i < tamano; i++)
				entrenadorClone.listaPokemones.add((Pokemon) this.listaPokemones.get(i).clone());
			
			
			entrenadorClone.listaCartas = (ArrayList<ICarta>) this.listaCartas.clone();
			entrenadorClone.listaCartas.clear();
			int tamanoC = this.listaCartas.size();
			for (int i = 0; i < tamanoC; i++)
				entrenadorClone.listaCartas.add((ICarta)this.listaCartas.get(i).clone());	
		}
		return entrenadorClone;
	}

	@Override
	public String toString()
	{
		return "Entrenador [nombre=" + nombre + ", numeroCartasParaUso=" + this.numeroCartasParaUso + ", puntosDeBatalla="
				+ puntosDeBatalla + "]";
	}

	public String detallePokemones()
	{
		StringBuilder st = new StringBuilder();
		Iterator<Pokemon> it = this.listaPokemones.iterator();

		while (it.hasNext())
		{
			st.append(it.next().toString());
			st.append("\n");
		}

		return st.toString();
	}
	
}
