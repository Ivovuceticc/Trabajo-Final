package Modelo;

public class DecoratorHada extends DecoratorPokemon
{
	private static final long serialVersionUID = 1L;
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
		if(this.auraDeHada)
			this.auraDeHada = false;
		this.fuerza *= 0.7;
	}

	public void hechizoViento()
	{
		this.vitalidad *= 0.85;
	}

	public void hechizoTormenta()
	{
		if(this.auraDeHada)
			this.auraDeHada = false;
		this.fuerza *= 0.8;
		this.escudo *= 0.9;
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
				+ ", experiencia=" + experiencia + this.getTipo()+ " encapsulado: " + encapsulado;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		DecoratorHada decoradorClonado = null;
		decoradorClonado = (DecoratorHada)super.clone();
		decoradorClonado.encapsulado = (Pokemon)encapsulado.clone();
		return decoradorClonado; 
	}
	
}
