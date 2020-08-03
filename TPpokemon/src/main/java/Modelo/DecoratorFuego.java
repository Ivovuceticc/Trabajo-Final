package Modelo;

public class DecoratorFuego extends DecoratorPokemon
{
	private static final long serialVersionUID = 1L;
	private boolean recargaFuego;
	private boolean auraDeFuego;

	public DecoratorFuego(Pokemon encapsulado)
	{
		super(encapsulado);
		this.fuerza = encapsulado.fuerza + 140;
		this.escudo = encapsulado.escudo + 100;
		this.vitalidad = encapsulado.vitalidad + 480;
		this.recargaFuego = true;
		this.auraDeFuego = true;
	}

	@Override
	protected void golpeFinal(Pokemon adversario)
	{
		adversario.recibeDano(this.fuerza * 1.25);
		this.fuerza = 0;
	}

	@Override
	protected void recibeDano(double dano)
	{
		if (auraDeFuego)
			this.vitalidad *= 1.1;

		if (dano < (this.vitalidad + this.escudo))
		{
			if (dano * 0.5 < this.escudo)
			{
				this.escudo -= dano * 0.5;
				if (dano * 0.5 < this.vitalidad)
					this.vitalidad -= dano * 0.5;
				else
				{
					this.escudo -= (dano * 0.5 - this.vitalidad);
					this.vitalidad = 0;
				}
			} else
			{
				this.vitalidad -= (dano - this.escudo);
				this.escudo = 0;
			}
		} else
		{
			this.escudo = 0;
			this.vitalidad = 0;
		}
	}

	protected void recarga()
	{
		if (recargaFuego)
		{
			this.fuerza *= 1.1;
			this.vitalidad *= 1.1;
		} else
			encapsulado.recarga();
	}

	public void hechizoNiebla()
	{
		if (this.auraDeFuego)
			this.auraDeFuego = false;
		this.vitalidad *= 0.85;
		this.escudo *= 0.8;
	}

	public void hechizoViento()
	{
		if (this.recargaFuego)
			this.recargaFuego = false;
		this.vitalidad *= 0.85;
		this.fuerza *= 0.9;
	}

	public void hechizoTormenta()
	{
		if (this.recargaFuego)
			this.recargaFuego = false;
		this.escudo *= 0.5;
	}

	@Override
	protected String getTipo()
	{
		return encapsulado.getTipo() + " De Fuego";
	}


	@Override
	public Object clone() throws CloneNotSupportedException
	{
		DecoratorFuego decoradorClonado = null;
		decoradorClonado = (DecoratorFuego) super.clone();
		decoradorClonado.encapsulado = (Pokemon) encapsulado.clone();
		return decoradorClonado;
	}

	@Override
	public String toString()
	{
		return "Pokemon nombre=" + nombre + ", escudo=" + escudo + ", vitalidad=" + vitalidad + ", fuerza=" + fuerza
				+ ", experiencia=" + experiencia + this.getTipo() + " encapsulado: " + encapsulado;
	}
}
