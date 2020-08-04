package Modelo;

/**
 * @author Vucetic Ivo Clase que se encarga de sumar funcionalidad de tipo agua
 *         a un objeto de tipo pokemon.
 */
public class DecoratorAgua extends DecoratorPokemon
{
	private static final long serialVersionUID = 1L;
	private boolean recargaAgua;
	private boolean auraDeAgua;

	/**
	 * Constructor del tipo decorador de agua, se encarga de setear los parametros
	 * de fuerza, escudo y vitalidad sumandole 120, 100 y 500 a los parametros del encapsulado. <b>pre:</b>
	 * encapsulado != null.
	 * 
	 * @param encapsulado: Parámetro de tipo pokemon que representa al pokemon que
	 *                     se le dará mas funcionalidad.
	 */
	public DecoratorAgua(Pokemon encapsulado)
	{
		super(encapsulado);
		this.fuerza = encapsulado.fuerza + 120;
		this.escudo = encapsulado.escudo + 100;
		this.vitalidad = encapsulado.vitalidad + 500;
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
		if (auraDeAgua)
			this.escudo *= 1.1;

		if (dano < this.escudo)
			this.escudo -= dano;
		else
		{
			if (dano < (this.escudo + this.vitalidad))
				this.vitalidad -= dano - this.escudo;
			else
				this.vitalidad = 0;
			this.escudo = 0;
		}

	}

	protected void recarga()
	{
		if (recargaAgua)
		{
			this.fuerza *= 1.1;
			this.vitalidad *= 1.1;
		} else
			encapsulado.recarga();
	}

	public void hechizoNiebla()
	{
		if (this.auraDeAgua)
			this.auraDeAgua = false;
		this.vitalidad *= 0.75;
		this.escudo *= 0.9;
	}

	public void hechizoViento()
	{
		if (this.recargaAgua)
			this.recargaAgua = false;
		this.fuerza *= 0.8;
		this.escudo *= 0.8;
	}

	public void hechizoTormenta()
	{
		this.vitalidad *= 0.7;
	}

	@Override
	protected String getTipo()
	{
		return encapsulado.getTipo() + " De Agua";
	}

	@Override
	public String toString()
	{
		return "Pokemon nombre=" + nombre + ", escudo=" + escudo + ", vitalidad=" + vitalidad + ", fuerza=" + fuerza
				+ ", experiencia=" + experiencia + this.getTipo() + " encapsulado: " + encapsulado;
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		DecoratorAgua decoradorClonado = null;
		decoradorClonado = (DecoratorAgua) super.clone();
		if (encapsulado != null)
			decoradorClonado.encapsulado = (Pokemon) encapsulado.clone();
		return decoradorClonado;
	}

}
