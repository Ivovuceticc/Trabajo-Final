package Modelo;

/**
 * @author Vucetic Ivo Interface que se encargará de brindar el comportamiento
 *         de establecer una categoria. Se podrá obtener dicha categoria o
 *         actualizar el estado de la misma.
 */
public interface Clasificable
{
	String getCategoria();

	boolean actualizaCategoria();
}
