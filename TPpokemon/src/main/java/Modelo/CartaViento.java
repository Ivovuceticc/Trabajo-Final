package Modelo;

import java.io.Serializable;

/**
 * @author Vucetic Ivo
 *Esta clase representa uno de los tres tipos de cartas que tienen cada entrenador, el tipo Viento.<br>
 *Dispone de una cantidad de cartas de este tipo y su correspondiente nombre.<br>
 *Tendrá la posibilidad de clonarse.
 */

public class CartaViento implements ICarta, Cloneable, Serializable
{	
	protected int cantidad;
	public String Nombre;

	/**
	 * Constructor para inicilizar la cantidad de cartas(podrá usar hasta dos) de este tipo y su nombre.<br>
	 */
	public CartaViento()
	{
		this.cantidad = 2;
		this.Nombre = "Carta Viento";
	}
	
	/**
	 *Por polimorfismo se hechizará con la Carta Viento a un objeto de tipo Hehizable sufriendo las consecuencias de dicho hechizo dependiendo del tipo.<br>
	 * <b>Pre:</b> hechizable debe ser distinto de null.
	 * <b>Post:</b> Se lanza el hechizo.
	 *@param hechizable: Parámetro de tipo Hechizable que representa un objeto que podría ser cualquiera de todos los tipo de pokemones del torneo(En este programa).<br> 
	 */
	public void hechizar(Hechizable hechizable)
	{
		hechizable.hechizoViento();	
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
		return "CartaViento [cantidad=" + cantidad + ", Nombre=" + Nombre + "]";
	}
	
	/**
	 *Método que se encarga de clonar a la carta. Dicha carta se puede clonar siempre, por ende no arrojará excepción de tipo CloneNotSupportedException. <br>
	 * <b>Post:</b> Se clona la CartaViento.
	 */
	@Override
	public Object clone() 
	{
		CartaViento cartaClone = null;
		try
		{
			cartaClone = (CartaViento)super.clone();
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return cartaClone;
	}

}
