package Modelo;

public class DecoratorRoca extends DecoratorPokemon
{
	private boolean auraDeRoca;

	public DecoratorRoca(Pokemon encapsulado)
	{
		super(encapsulado);
		this.fuerza = encapsulado.fuerza + 70;
		this.escudo = encapsulado.escudo + 130;
		this.vitalidad = encapsulado.vitalidad + 520;
		this.auraDeRoca = true;
	}

	@Override
	protected void golpeFinal(Pokemon adversario)
	{
		adversario.recibeDano(this.fuerza * 1.2);
	}

	@Override
	protected void recibeDano(double dano)
	{
		if (auraDeRoca)
		{
			this.vitalidad *= 1.1;
			this.escudo *= 1.1;
		}

		if (dano < (this.vitalidad + this.escudo))
		{
			if (dano * 0.8 < this.escudo)
			{
				this.escudo -= dano * 0.8;
				if (dano * 0.2 < this.vitalidad)
					this.vitalidad -= dano * 0.2;
				else
				{
					this.escudo -= (dano * 0.2 - this.vitalidad);
					this.vitalidad = 0;
				}
			} 
			else
			{	
				this.vitalidad -= (dano - this.escudo);
				this.escudo = 0;
			}
		}
		else
		{
			this.escudo = 0;
			this.vitalidad = 0;
		}
	}
	
	public void hechizoNiebla()
	{
		this.encapsulado.hechizoNiebla();
		if(this.auraDeRoca)
			this.auraDeRoca = false;
	}

	public void hechizoViento()
	{
		this.encapsulado.hechizoViento();
		this.vitalidad *= 0.9;
		this.escudo *= 0.9;
	}

	public void hechizoTormenta()
	{
		this.encapsulado.hechizoTormenta();
		this.vitalidad *= 0.8;
	}
	
	@Override
	public String toString()
	{
		return encapsulado.toString() +" ,Elemento:Roca";
	}
}
