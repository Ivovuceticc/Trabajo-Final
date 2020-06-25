package Modelo;

public interface ICarta
{
	void hechizar(Hechizable hechizable);
	void setCantidad(int cantidad);
	int getCantidad();
	String getNombre();
	Object clone(); 
}
