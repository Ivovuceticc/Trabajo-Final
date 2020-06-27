package Modelo;

/**
 * @author Vucetic Ivo
 *Esta clase representa uno de los tres tipos de cartas que tienen cada entrenador, el tipo niebla.<br>
 *Dispone de una cantidad de cartas de este tipo y su correspondiente nombre.<br>
 *Tendrá la posibilidad de clonarse.
 */
public class CartaNiebla implements ICarta, Cloneable
{
	private int cantidad;
	private String Nombre;

	/**
	 * Constructor para inicilizar la cantidad de cartas de este tipo y su nombre.
	 */
	public CartaNiebla()
	{
		this.cantidad = 2;
		this.Nombre = "Carta Niebla";
	}

	/**
	 *Este método 
	 *@param hechizable:  
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
