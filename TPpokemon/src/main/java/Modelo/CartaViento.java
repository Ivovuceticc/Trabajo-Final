package Modelo;

public class CartaViento implements ICarta
{	
	public final int cantidad = 2;

	public void hechizar(Hechizable hechizable)
	{
		hechizable.hechizoViento();
	}

	public int getCantidad()
	{
		return cantidad;
	}
	
}
