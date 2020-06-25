package Modelo;

public class CartaTormenta implements ICarta, Cloneable
{
	protected int cantidad;
	public String Nombre;

	public CartaTormenta()
	{
		this.cantidad = 2;
		this.Nombre = "Carta Tormenta";
	}

	public void hechizar(Hechizable hechizable)
	{
		hechizable.hechizoTormenta();	
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
		return "CartaTormenta [cantidad=" + cantidad + ", Nombre=" + Nombre + "]";
	}
	
	@Override
	public Object clone() 
	{
		CartaTormenta cartaClone = null;
		try
		{
			cartaClone = (CartaTormenta)super.clone();
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return cartaClone;
	}
		
}
