package Modelo;

public interface IState
{
	void presentarRivales(Entrenador entrenador1, Entrenador entrenador2);
	void comenzarBatalla();
	void obtenerResultados();
}
