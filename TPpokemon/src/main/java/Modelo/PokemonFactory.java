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

		if (encapsulado != null && elemento != "")
		{
			String elem = (String)elemento;
			if(elem.equalsIgnoreCase("Fuego"))
				respuesta = new DecoratorFuego(encapsulado);
			else if(elem.equalsIgnoreCase("Agua"))
				respuesta = new DecoratorAgua(encapsulado);
			else if(elem.equalsIgnoreCase("Roca"))
				respuesta = new DecoratorRoca(encapsulado);
			else if(elem.equalsIgnoreCase("Hada"))
				respuesta = new DecoratorHada(encapsulado);
			else if(elem.equalsIgnoreCase("Hielo"))
				respuesta = new DecoratorHielo(encapsulado);
		}
		else if(encapsulado != null && elemento == "")
				respuesta = encapsulado;
			
		
		return respuesta;
	}
}
