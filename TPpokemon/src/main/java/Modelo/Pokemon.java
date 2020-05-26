package Modelo;

public abstract class Pokemon
{
	protected String nombre;
	protected double escudo, vitalidad, fuerza;
	protected int experiencia;

	public Pokemon(String nombre)
	{
		this.nombre = nombre;
	}

	public Pokemon(String nombre, double vitalidad, double escudo, double fuerza, int experiencia)
	{
		this.nombre = nombre;
		this.escudo = escudo;
		this.vitalidad = vitalidad;
		this.fuerza = fuerza;
		this.experiencia = 0;
	}

	// Usar metodo template
	public void atacar(Pokemon adversario)
	{
		this.golpeInicial(adversario);
		this.recarga(); // Hook
		this.golpeFinal(adversario);
	}

	protected void golpeInicial(Pokemon adversario)
	{
		adversario.recibeDano(this.fuerza);
		this.fuerza *= 0.5;
	}

	protected void recarga()
	{
		System.out.println("No es posible recargarse");
	}

	protected abstract void golpeFinal(Pokemon adversario);

	protected abstract void recibeDano(double dano);
}
