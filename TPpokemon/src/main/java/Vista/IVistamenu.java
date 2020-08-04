package Vista;

import java.awt.event.ActionListener;

/**
 * @author Vucetic Ivo
 * Interface para poder ajustarle un actionLister a la vista menu y poder cerrar ventana.<br>
 */
public interface IVistamenu
{
	void setActionListener(ActionListener actionListener);
	void cerrarVentana();
}
