package Modelo;

public abstract class DecoratorPokemon extends Pokemon
{
	private static final long serialVersionUID = 1L;
	protected Pokemon encapsulado;

	public DecoratorPokemon(Pokemon encapsulado)
	{
		super(encapsulado.nombre);	
		this.encapsulado = encapsulado;
	}
	
	public Pokemon getEncapsulado()
	{
		return encapsulado;
	}
}
