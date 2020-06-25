package Vista;

import java.awt.event.ActionListener;
import java.util.Iterator;

import Modelo.Entrenador;

public interface IVistaInscripcion
{
	void setActionListener(ActionListener actionListener);
	void cerrarVentana();
	String getNombreEntrenador();
	String getNombrePokemon();
	String getTipo();
	String getTipoElemento();
	void altaEntrenador();
	void altaPokemon(int cont1, int cont2);
	void habilitaElemento();
	void deshabilitaElemento();
	void actualizarListaEntrenador(Iterator<Entrenador> iterator);
	void agregaLog(String lineaTexto);
}
