package Modelo;

public class CartaViento implements ICarta
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
}
