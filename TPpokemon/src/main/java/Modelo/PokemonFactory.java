package Modelo;


/**
 * @author Vucetic Ivo
 * La clase representa la forma en que se creará un objeto de tipo pokemon. 
 */
public class PokemonFactory
{
	/**
	 * Este método se encarga de crear un nuevo pokemon, dado el nombre, el tipo y su elemento.
	 * <b>Pre:</b> nombre,tipo y elemento != null.
	 * @param nombre: Parámetro de tipo String que representa el nombre de un pokemon.
	 * @param tipo: Parámetro de tipo String que representa el tipo del comun que será comun o legendario.
	 * @param elemento: Parámetro de tipo String que representa el elemento del pokemon, ya sea hada,fuego,agua,hielo o roca.
	 * @return Un nuevo pokemon.
	 */
	public static Pokemon getPokemon(String nombre, String tipo, String elemento)
	{
		Pokemon encapsulado = null;
		Pokemon respuesta = null;

		if (tipo.equalsIgnoreCase("Comun"))
			encapsulado = new PokemonComun(nombre);
		else if (tipo.equalsIgnoreCase("Legendario"))
			encapsulado = new PokemonLegendario(nombre);
		
		if (encapsulado != null && !elemento.equals(""))
		{
			if(elemento.equalsIgnoreCase("Fuego"))
				respuesta = new DecoratorFuego(encapsulado);
			else if(elemento.equalsIgnoreCase("Agua"))
				respuesta = new DecoratorAgua(encapsulado);
			else if(elemento.equalsIgnoreCase("Roca"))
				respuesta = new DecoratorRoca(encapsulado);
			else if(elemento.equalsIgnoreCase("Hada"))
				respuesta = new DecoratorHada(encapsulado);
			else if(elemento.equalsIgnoreCase("Hielo"))
				respuesta = new DecoratorHielo(encapsulado);
		}
		else if(encapsulado != null && elemento.equals("")) 
				respuesta = encapsulado;		
			
		
		return respuesta;
	}
}
