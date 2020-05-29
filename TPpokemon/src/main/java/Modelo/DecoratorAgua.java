package Modelo;

public class DecoratorAgua extends DecoratorPokemon
{
	private boolean recargaAgua;
	private boolean auraDeAgua;
	

	public DecoratorAgua(Pokemon encapsulado)
	{
		super(encapsulado);
		this.fuerza = encapsulado.fuerza + 120;
		this.escudo = encapsulado.escudo + 100;
		this.vitalidad = encapsulado.vitalidad + 200;
		this.recargaAgua = true;
		this.auraDeAgua = true;
	}

	@Override
	protected void golpeFinal(Pokemon adversario)
	{
		adversario.recibeDano(this.fuerza);
		this.fuerza *= 0.5;
	}

	@Override
	protected void recibeDano(double dano)
	{	
		if(auraDeAgua)
			this.escudo *= 1.1;
		
		if (dano < this.escudo)
			this.escudo -= dano;
		else
		{
			if (dano < (this.escudo + this.vitalidad))
				this.vitalidad -= dano - this.escudo;
			else
				this.vitalidad = 0;					//Ver que pasa cuando muere
			this.escudo = 0;
		}
		
	}

	protected void recarga()
	{
		if (recargaAgua)
		{
			this.fuerza *= 1.1;
			this.vitalidad *= 1.1;
		}
		else
			encapsulado.recarga();
	}

	public void hechizoNiebla()
	{
		this.encapsulado.hechizoNiebla();
		if(this.auraDeAgua)
			this.auraDeAgua = false;
	}

	public void hechizoViento()
	{
		this.encapsulado.hechizoViento();
		if(this.recargaAgua)
			this.recargaAgua = false;
	}

	public void hechizoTormenta()
	{
		this.encapsulado.hechizoTormenta();
		this.vitalidad *= 0.8;
	}

}
