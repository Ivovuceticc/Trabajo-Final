package Modelo;

public class NumeroNoValidoException extends Exception
{
	public int numeroInvalido;
	
	public NumeroNoValidoException(String mensaje, int falla)
	{
		super(mensaje);
		this.numeroInvalido = falla;
	}

	public int getNumeroInvalido()
	{
		return numeroInvalido;
	}
}
