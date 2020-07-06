package Modelo;

/**
 * @author Vucetic Ivo<br>
 *Clase que representa un tipo de excepci�n que se da cuando el entrenador ya utiliz� todas las cartas que tiene disponible
 *o cuando se consume un tipo de carta especifico.
 */
public class ExcedeCantidadHechizosException extends Exception
{	
	public int cartasParaUso;
	public int cartasUsadas;
	
	/**
	 * Constructor con tres parametros para setear el mensaje que va a arrojar la excepci�n, la cantidad de cartas que podia usar, y las cartas que se usaron.<br>
	 * @param mensaje: par�metro de tipo String que representa el mensaje que arrojar� cuando se efect�e la excepci�n.<br>
	 * @param cartasParaUso: par�metro de tipo int que representa la cantidad de cartas que pod�a utilizar.<br>
	 * @param cartasUsadas: par�metro de tipo int que representa la cantidad de cartas que se usaron.<br>
	 */
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
