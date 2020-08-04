package Vista;

import java.awt.event.ActionListener;

/**
 * @author Vucetic Ivo Interface que le da funcionalidad para mostrar mensajes
 *         en cada uno de los paneles de la vistaArena y poder ajustarle un actionLister a la vista.<br>
 */
public interface IVistaArenas
{
	void setActionListener(ActionListener actionListener);
	
	void agregaLogOeste(String lineaTexto);

	void agregaLogCentral(String lineaTexto);

	void agregaLogEste(String lineaTexto);

	void agregaLogSur(String lineaTexto);
}
