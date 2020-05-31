package Modelo;

public class DecoratorTierra extends DecoratorPokemon
{
	public DecoratorTierra(Pokemon encapsulado)
	{
		super(encapsulado);
		this.fuerza = encapsulado.fuerza + 60;
		this.escudo = encapsulado.escudo + 120;
		this.vitalidad = encapsulado.vitalidad + 540;
	}

	@Override
	protected void golpeFinal(Pokemon adversario)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void recibeDano(double dano)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hechizoNiebla()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hechizoViento()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hechizoTormenta()
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected String getTipo()
	{
		return encapsulado.getTipo() + " De Fuego";
	}
	
	@Override
	public String toString()
	{
		return encapsulado.toString() + this.getTipo();
	}
}
