package Modelo;

public class PokemonComun extends Pokemon
{
	private static final long serialVersionUID = 1L;

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
				this.vitalidad = 0;					
			this.escudo = 0;
		}
	}

	public void hechizoNiebla()
	{
		this.vitalidad *= 0.9;
		this.fuerza *= 0.9;
	}

	public void hechizoViento()
	{
		this.vitalidad *= 0.8;
		this.escudo *= 0.9; 
	}

	public void hechizoTormenta()
	{
		this.fuerza *= 0.8;
	}
	
	@Override
	protected String getTipo()
	{
		return " PokemonComun";
	}
	
	@Override
	public String toString()
	{
		return super.toString()+ this.getTipo();
	}

	@Override
	public Object clone() 
	{
		PokemonComun pokemonClonado = null;
		
			try
			{
				pokemonClonado = (PokemonComun)super.clone();
			} 
			catch (CloneNotSupportedException e)
			{
				e.printStackTrace();
			}
			return pokemonClonado;
	}
	
}
