package Modelo;

public class CartaNiebla implements ICarta
{
	public final int cantidad = 2;	

	public void hechizar(Hechizable hechizable)
	{
		hechizable.hechizoNiebla();
	}

	public int getCantidad()
	{
		return cantidad;
	}
	
}
