package Modelo;

public class CartaViento implements ICarta
{	
	public static final int cantidad = 2;

	public void hechizar(Hechizable hechizable)
	{
		hechizable.hechizoViento();
	}

}
