package Modelo;

public class PokemonComun extends Pokemon
{
	
	public PokemonComun(String nombre)
	{
		super(nombre, 100, 20, 25, 0); // Inicializo cualquier pokemon que sea de tipo comun
	}

	@Override
	protected void golpeFinal(Pokemon adversario)
	{
		adversario.recibeDano(this.fuerza);
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
				this.vitalidad = 0;					//Ver que pasa cuando muere
			this.escudo = 0;
		}
	}
	
}
