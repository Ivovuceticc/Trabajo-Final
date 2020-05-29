package Modelo;

public class CartaTormenta implements ICarta
{
	public final int cantidad = 2;
	
	public void hechizar(Hechizable hechizable)
	{
		hechizable.hechizoTormenta();
	}

	public int getCantidad()
	{
		return cantidad;
	}

		
}
