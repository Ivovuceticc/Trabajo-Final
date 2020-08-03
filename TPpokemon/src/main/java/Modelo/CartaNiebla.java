package Modelo;

import java.io.Serializable;

/**
 * @author Vucetic Ivo
 *Esta clase representa uno de los tres tipos de cartas que tienen cada entrenador, el tipo niebla.<br>
 *Dispone de una cantidad de cartas de este tipo y su correspondiente nombre.<br>
 *Tendrá la posibilidad de clonarse.
 */
public class CartaNiebla implements ICarta, Cloneable, Serializable
{
	private int cantidad;
	private String Nombre;

	/**
	 * Constructor para inicilizar la cantidad de cartas(podrá usar hasta dos) de este tipo y su nombre.<br>
	 */
	public CartaNiebla()
	{
		this.cantidad = 2;
		this.Nombre = "Carta Niebla";
	}

	/**
	 *Por polimorfismo se hechizará con la Carta Niebla a un objeto de tipo Hehizable sufriendo las consecuencias de dicho hechizo dependiendo del tipo.<br>
	 * <b>Pre:</b> hechizable debe ser distinto de null.
	 * <b>Post:</b> Se lanza el hechizo.
	 *@param hechizable: Parámetro de tipo Hechizable que representa un objeto que podría ser cualquiera de todos los tipo de pokemones del torneo(En este programa).<br> 
	 */
	public void hechizar(Hechizable hechizable)
	{
		hechizable.hechizoNiebla();
	}

	public int getCantidad()
	{
		return cantidad;
	}
	
	@Override
	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}

	@Override
	public String getNombre()
	{
		return this.Nombre;
	}

	@Override
	public String toString()
	{
		return "CartaNiebla [cantidad=" + cantidad + ", Nombre=" + Nombre + "]";
	}
	
	/**
	 *Método que se encarga de clonar a la carta. Dicha carta se puede clonar siempre, por ende no arrojará excepción de tipo CloneNotSupportedException. <br>
	 * <b>Post:</b> Se clona la CartaNiebla.
	 */
	@Override
	public Object clone() 
	{
		CartaNiebla cartaClone = null;
		try
		{
			cartaClone = (CartaNiebla)super.clone();
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return cartaClone;
	}
}
