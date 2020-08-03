package Modelo;

public class DecoratorHielo extends DecoratorPokemon
{
	private static final long serialVersionUID = 1L;
	private boolean granRecarga;
	private boolean auraDeHielo;

	public DecoratorHielo(Pokemon encapsulado)
	{
		super(encapsulado);
		this.fuerza = encapsulado.fuerza + 100;
		this.escudo = encapsulado.escudo + 120;
		this.vitalidad = encapsulado.vitalidad + 500;
		this.auraDeHielo = true;
		this.granRecarga = true;
	}

	@Override
	protected void golpeFinal(Pokemon adversario)
	{
		adversario.recibeDano(this.fuerza * 0.9);
	}

	@Override
	protected void recibeDano(double dano)
	{
		if (auraDeHielo)
		{
			this.vitalidad *= 1.05;
			this.escudo *= 1.05;
		}

		if (dano < (this.vitalidad + this.escudo))
		{
			if (dano * 0.75 < this.escudo)
			{
				this.escudo -= dano * 0.75;
				if (dano * 0.25 < this.vitalidad)
					this.vitalidad -= dano * 0.25;
				else
				{
					this.escudo -= (dano * 0.25 - this.vitalidad);
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

	protected void recarga()
	{
		if (granRecarga)
			this.fuerza = 400;
		else
			encapsulado.recarga();
	}
	
	public void hechizoNiebla()
	{
		if(this.auraDeHielo)
			this.auraDeHielo = false;
		this.escudo *= 0.85;
		this.vitalidad *= 0.9;
		this.fuerza *= 0.95;
	}

	public void hechizoViento()
	{
		if(this.granRecarga)
			this.granRecarga = false;
		this.vitalidad *= 0.9;
		this.fuerza *= 0.8;
	}

	public void hechizoTormenta()
	{
		this.vitalidad *= 0.8;
	}
	@Override
	protected String getTipo()
	{
		return encapsulado.getTipo() + " De Hielo";
	}
	
	@Override
	public String toString()
	{
		return  "Pokemon nombre=" + nombre + ", escudo=" + escudo + ", vitalidad=" + vitalidad + ", fuerza=" + fuerza
				+ ", experiencia=" + experiencia + this.getTipo()+ " encapsulado: " + encapsulado;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		DecoratorHielo decoradorClonado = null;
		decoradorClonado = (DecoratorHielo)super.clone();
		decoradorClonado.encapsulado = (Pokemon)encapsulado.clone();
		return decoradorClonado; 
	}
	
}
