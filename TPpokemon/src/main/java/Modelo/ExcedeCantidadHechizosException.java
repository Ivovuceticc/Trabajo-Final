package Modelo;

public class ExcedeCantidadHechizosException extends Exception
{	
	public int cartasParaUso;
	public int cartasUsadas;
	
	public ExcedeCantidadHechizosException(String mensaje, int cartasParaUso, int cartasUsadas)
	{
		super(mensaje);
		this.cartasParaUso = cartasParaUso;
		this.cartasUsadas = cartasUsadas;
	}

	public int getCartasParaUso()
	{
		return cartasParaUso;
	}

	public int getCartasUsadas()
	{
		return cartasUsadas;
	}
	
}
