package Modelo;

public class CartaTormenta implements ICarta
{
	public static final int cantidad = 2;
	
	public void hechizar(Hechizable hechizable)
	{
		hechizable.hechizoTormenta();
	}

}
