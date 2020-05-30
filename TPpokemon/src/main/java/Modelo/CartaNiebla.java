package Modelo;

public class CartaNiebla implements ICarta
{
	private int cantidad;
	private String Nombre;

	public CartaNiebla()
	{
		this.cantidad = 2;
		this.Nombre = "Carta Niebla";
	}

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

}
