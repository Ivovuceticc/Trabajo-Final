package Modelo;

public class PokemonLegendario extends Pokemon
{
	
	public PokemonLegendario(String nombre)
	{
		super(nombre, 200, 40, 50, 0); // Inicializo cualquier pokemon que sea de tipo comun
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
	
}
