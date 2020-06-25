package Modelo;

public class CartaViento implements ICarta, Cloneable
{	
	protected int cantidad;
	public String Nombre;

	public CartaViento()
	{
		this.cantidad = 2;
		this.Nombre = "Carta Viento";
	}

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
