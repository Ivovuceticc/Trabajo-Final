package Vista;

import java.awt.event.ActionListener;
import java.util.Iterator;

import Modelo.Entrenador;

/**
 * @author Vucetic Ivo Interface para a�adir funcionalidad a la ventana
 *         inscripcion, se va a poder asignarle un actionListener, poder cerrar
 *         la ventana, Obtener nombre de entrenador y pokemon, tambi�n obtener
 *         el tipo de los pokemones y su elemento. Podremos tambi�n dar el alta
 *         del entrenador y los pokemones.<br>
 *
 */
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

	void actualizarListaEntrenador(Iterator<Entrenador> iterator);

	void agregaLog(String lineaTexto);
}
