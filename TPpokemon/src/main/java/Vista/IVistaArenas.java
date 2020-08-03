package Vista;

import java.awt.event.ActionListener;

public interface IVistaArenas
{
	void setActionListener(ActionListener actionListener);
	void agregaLogOeste(String lineaTexto);
	void agregaLogCentral(String lineaTexto);
	void agregaLogEste(String lineaTexto);
	void agregaLogSur(String lineaTexto);
}
