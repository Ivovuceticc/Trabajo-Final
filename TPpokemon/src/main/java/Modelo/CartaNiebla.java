package Modelo;

public class CartaNiebla implements ICarta
{
	public static final int cantidad = 2;	

	public void hechizar(Hechizable hechizable)
	{
		hechizable.hechizoNiebla();
	}
}
