package Modelo;

public abstract class Pokemon implements Hechizable, Clasificable, Cloneable
{
	protected String nombre;
	protected double escudo, vitalidad, fuerza;
	private double escudoMax, vitalidadMax, fuerzaMax;
	protected int experiencia;
	private String categoria;

	public Pokemon(String nombre)
	{
		this.nombre = nombre;
	}
	
		public void setEscudo(double escudo)
	{
		this.escudo = escudo;
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
		System.out.println("\n "+this.nombre+ " No es posible que utilize la habilidad de recarga");
	}

	protected String getNombre()
	{
		return nombre;
	}
	
	
	@Override
	public String toString()
	{
		return "Pokemon nombre=" + nombre + ", escudo=" + escudo + ", vitalidad=" + vitalidad + ", fuerza=" + fuerza
				+ ", experiencia=" + experiencia;
	}

	public String getCategoria()
	{
		return categoria;
	}

	public boolean actualizaCategoria()
	{
		boolean respuesta = false;

		if (this.experiencia > 0 && this.experiencia <= 10 && !categoria.equalsIgnoreCase("Principiante"))
		{
			respuesta = true;
			this.categoria = "Principiante";
			this.escudoMax = 600;
			this.vitalidadMax = 1500;
			this.fuerzaMax = 500;
		} else if (this.experiencia > 10 && this.experiencia <= 30 && !categoria.equalsIgnoreCase("Intermedio"))
		{
			respuesta = true;
			this.categoria = "Intermedio";
			this.escudoMax = 1200;
			this.vitalidadMax = 3000;
			this.fuerzaMax = 1000;
		} else if (this.experiencia > 30 && this.experiencia <= 60 && !categoria.equalsIgnoreCase("Avanzado"))
		{
			respuesta = true;
			this.categoria = "Avanzado";
			this.escudoMax = 1800;
			this.vitalidadMax = 4500;
			this.fuerzaMax = 1500;
		}

		return respuesta;
	}

	public void cambiarPuntosDeBatalla(int puntos)
	{	
		this.vitalidad += puntos * 0.5;
		this.fuerza += puntos * 0.35;
		this.escudo += puntos * 0.15;
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	protected abstract String getTipo();

	protected abstract void golpeFinal(Pokemon adversario);

	protected abstract void recibeDano(double dano);

}
