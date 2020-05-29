package Modelo;

public class DecoratorElectrico extends DecoratorPokemon
{
	public DecoratorElectrico(Pokemon encapsulado)
	{
		super(encapsulado);
		this.fuerza = encapsulado.fuerza + 140;
		this.escudo = encapsulado.escudo + 80;
		this.vitalidad = encapsulado.vitalidad + 500;
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
}
