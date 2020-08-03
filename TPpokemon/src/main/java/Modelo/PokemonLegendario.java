package Modelo;

public class PokemonLegendario extends Pokemon
{
	private static final long serialVersionUID = 1L;

	public PokemonLegendario(String nombre)
	{
		super(nombre, 200, 40, 50, 0); // Inicializo cualquier pokemon que sea de tipo legendario
	}

	@Override
	protected void golpeFinal(Pokemon adversario)
	{
		adversario.recibeDano(this.fuerza + (this.escudo * 0.5));
	}

	@Override
	protected void recibeDano(double dano)
	{
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
		this.fuerza *= 1.05;
	}

	public void hechizoNiebla()
	{
		this.vitalidad *= 0.8;
		this.fuerza *= 0.8;
	}

	public void hechizoViento()
	{
		this.vitalidad *= 0.75;
		this.escudo *= 0.8; 
		
	}

	public void hechizoTormenta()
	{
		this.fuerza *= 0.4;
	}
	
	@Override
	protected String getTipo()
	{
		return " PokemonLegendario";
	}

	@Override
	public String toString()
	{
		return super.toString()+ this.getTipo();
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException("No se puede clonar un pokemon legendario!!");
	}
	
}
