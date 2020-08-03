package Modelo;


public class PokemonFactory
{
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
