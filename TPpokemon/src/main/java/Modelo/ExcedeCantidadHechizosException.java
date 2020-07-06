package Modelo;

/**
 * @author Vucetic Ivo<br>
 *Clase que representa un tipo de excepción que se da cuando el entrenador ya utilizó todas las cartas que tiene disponible
 *o cuando se consume un tipo de carta especifico.
 */
public class ExcedeCantidadHechizosException extends Exception
{	
	public int cartasParaUso;
	public int cartasUsadas;
	
	/**
	 * Constructor con tres parametros para setear el mensaje que va a arrojar la excepción, la cantidad de cartas que podia usar, y las cartas que se usaron.<br>
	 * @param mensaje: parámetro de tipo String que representa el mensaje que arrojará cuando se efectúe la excepción.<br>
	 * @param cartasParaUso: parámetro de tipo int que representa la cantidad de cartas que podía utilizar.<br>
	 * @param cartasUsadas: parámetro de tipo int que representa la cantidad de cartas que se usaron.<br>
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
