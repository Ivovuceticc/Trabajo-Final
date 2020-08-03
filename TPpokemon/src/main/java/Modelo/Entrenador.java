package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * @author Vucetic Ivo<br>
 *         Esta clase representa un entrenador.El mismo tendrá un nombre, dos
 *         listas, una de los pokemones que usará en el torneo y otra con las
 *         cartas hechizo, la categoria que podrá tener el entrenador y puntos
 *         de batalla que podrá usar para subir el poder de sus pokemones.
 *
 */
public class Entrenador implements Cloneable, Clasificable, Serializable
{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Pokemon> listaPokemones;
	private final int cantidadPokemones = 3;
	private final int cantidadTipoCartas = 3;
	private final int numeroCartasParaUso = 3;
	private ArrayList<ICarta> listaCartas;
	private int numeroCartasUsadas = 0, puntosDeBatalla = 0;
	private String categoria = "";

	/**
	 * Contructor con un parámetro para setear el nombre. Se inicializará las listas
	 * de pokemones y cartas.<br>
	 * Se creará una instancia para cada tipo de carta que podrá utilizar el
	 * entrenador durante el torneo. <br>
	 * 
	 * @param nombre: parámetro de tipo String que representa el nombre de un
	 *                entrenador.
	 */
	public Entrenador(String nombre)
	{
		this.nombre = nombre;
		this.listaPokemones = new ArrayList<Pokemon>(cantidadPokemones);
		this.listaCartas = new ArrayList<ICarta>(cantidadTipoCartas);
		this.listaCartas.add(new CartaNiebla());
		this.listaCartas.add(new CartaViento());
		this.listaCartas.add(new CartaTormenta());

	}

	/**
	 * Agrega un pokemon a la lista de pokemones. 
	 * <b>Pre:</b> pokemon != null y la lista de pokemones debe estar previamente inicializada.<br>
	 * <b>Post:</b> se agrega un pokemon a la lista.<br>
	 * 
	 * @param pokemon: parámetro de tipo Pokemon, que representa uno de los
	 *                 pokemones que formará parte del equipo del entrenador.
	 */
	public void agregaPokemon(Pokemon pokemon)
	{
		this.listaPokemones.add(pokemon);
	}

	public ArrayList<Pokemon> getListaPokemones()
	{
		return listaPokemones;
	}

	/**
	 * Toma el pokemon con mayor poder de batalla(suma de vitalidad, escudo y
	 * fuerza) de la lista de los pokemones y lo elimina de la lista ya que solo lo podrá usar para una batalla.
	 * <br>
	 * @return Devuelve el pokemon con mayor poder de batalla.
	 */
	public Pokemon eligePokemon()
	{
		Pokemon pokemonMax = null, pokemonAct;
		Iterator<Pokemon> it = this.listaPokemones.iterator();
		double poder = 0, poderMax = 0;

		while (it.hasNext())
		{
			pokemonAct = it.next();
			poder = pokemonAct.fuerza + pokemonAct.escudo + pokemonAct.vitalidad;
			if (pokemonMax == null || poder > poderMax)
			{
				poderMax = poder;
				pokemonMax = pokemonAct;
			}
		}
		this.listaPokemones.remove(pokemonMax);
		return pokemonMax;
	}

	/**
	 * Se toma de forma aleatoria una carta de la lista, en el caso de que ya no
	 * queden cartas de ese tipo, o si ya se usaron todas las cartas disponibles,
	 * arrojará una excepción. Caso contrario aumentará en uno las cartas en uso y
	 * se consume una de las cartas del tipo utilizado. <br>
	 * @return En el caso de que no se arroje excepción devolverá una carta de su
	 *         mazo.<br>
	 * @throws ExcedeCantidadHechizosException: Nos dirá que ya no quedan cartas de
	 *                                          ese tipo o que se han usado todas las cartas disponibles.
	 */
	public ICarta eligeCarta() throws ExcedeCantidadHechizosException
	{
		ICarta carta = null;
		Random r = new Random();

		carta = this.listaCartas.get(r.nextInt(this.listaCartas.size()));
		if (this.numeroCartasUsadas <= this.numeroCartasParaUso)
		{
			if (carta.getCantidad() == 0)
				throw new ExcedeCantidadHechizosException("Ya no quedan " + carta.getNombre() + " !!!", 2, 2);
			else 
			{	
				this.numeroCartasUsadas++;
				carta.setCantidad(carta.getCantidad()-1);
			}
		}
		else
			throw new ExcedeCantidadHechizosException("Se han usado todas las cartas hechizo!!!", this.numeroCartasParaUso, this.numeroCartasUsadas);

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

	public int getCantidadpokemones()
	{
		return cantidadPokemones;
	}

	/**
	 *Este método verificará si cambia la categoria de un entrenador. Para eso se sumará el nivel de experiencia de todos los pokemones 
	 *con los que cuenta el entrenador. Si la experiencia acumulada es mayor que 0 pero inclusive menor a 50 y no tiene la categoria
	 *de Principiante al momento de verificar el cambio, este cambiará a dicha categoria y se le sumará 400 puntos de batalla.
	 *Si la experiencia acumulada es mayor que 50 pero inclusive menor a 100 y no tiene la categoria
	 *de Intermedio al momento de verificar el cambio, este cambiará a dicha categoria y se le sumará 800 puntos de batalla.
	 *Si la experiencia acumulada es mayor que 100 pero inclusive menor a 150 y no tiene la categoria
	 *de Avanzado al momento de verificar el cambio, este cambiará a dicha categoria y se le sumará 1200 puntos de batalla.<br>
	 *@return Devuelve verdadero en el caso de que haya cambiado de categoria o falso en caso contrario. 
	 */
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

	/**
	 *Se encarga de clonar a un entrenador. Primero se encargará de clonar toda la lista de pokemones. Como dicha lista puede presentar pokemones 
	 *que no puedan ser clonados es posible que se ejecute una excepcion del tipo CloneNotSupportedException. Luego se hará la clonación de las cartas
	 *estas no tienen riesgo de generar la excepción previamente aclarada, lo mismo va para las variables de instancia primitivas.<br>
	 *@exception CloneNotSupportedException: Cuando se intente clonar un pokemon que no acepte clonación.<br>
	 *@return Devuelve al entrenador clonado o null en el caso de que ocurra la excepción.<br>
	 */
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
				entrenadorClone.listaCartas.add((ICarta) this.listaCartas.get(i).clone());
		}
		return entrenadorClone;
	}

	@Override
	public String toString()
	{
		return "Entrenador [nombre=" + nombre + ", numeroCartasUsadas=" + this.numeroCartasUsadas
				+ ", puntosDeBatalla=" + puntosDeBatalla + "]";
	}

	/**
	 * Se detallan todos los pokemones que tiene el entrenador en su lista.<br>
	 * @return String con cada uno de los pokemones.<br>
	 */
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

	public void setPuntosDeBatalla(int puntosDeBatalla)
	{
		this.puntosDeBatalla = puntosDeBatalla;
	}

}
