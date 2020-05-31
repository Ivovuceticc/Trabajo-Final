package Modelo;

public class DecoratorHada extends DecoratorPokemon
{
	private boolean auraDeHada;

	public DecoratorHada(Pokemon encapsulado)
	{
		super(encapsulado);
		this.fuerza = encapsulado.fuerza + 160;
		this.escudo = encapsulado.escudo + 60;
		this.vitalidad = encapsulado.vitalidad + 500;
		this.auraDeHada = true;
	}

	@Override
	protected void golpeFinal(Pokemon adversario)
	{
		adversario.recibeDano(this.fuerza * 1.15);
		this.escudo += 30;
	}

	@Override
	protected void recibeDano(double dano)
	{
		if (auraDeHada)
			this.escudo *= 1.05;
		
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

	public void hechizoNiebla()
	{
		this.encapsulado.hechizoNiebla();
		if(this.auraDeHada)
			this.auraDeHada = false;
	}

	public void hechizoViento()
	{
		this.encapsulado.hechizoViento();
		this.vitalidad *= 0.85;
	}

	public void hechizoTormenta()
	{
		this.encapsulado.hechizoTormenta();
		this.fuerza *= 0.8;
	}
	
	@Override
	protected String getTipo()
	{
		return encapsulado.getTipo() + " De Hada";
	}
	
	@Override
	public String toString()
	{
		return  "Pokemon nombre=" + nombre + ", escudo=" + escudo + ", vitalidad=" + vitalidad + ", fuerza=" + fuerza
				+ ", experiencia=" + experiencia + this.getTipo();
	}
	
}
