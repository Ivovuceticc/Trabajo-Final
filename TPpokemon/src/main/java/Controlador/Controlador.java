package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import Modelo.Entrenador;
import Modelo.Pokemon;
import Modelo.PokemonFactory;
import Modelo.Torneo;
import Vista.IVistaArenas;
import Vista.IVistaInscripcion;
import Vista.IVistamenu;
import Vista.VentanaArena;
import Vista.VentanaInscripcion;
import Vista.VentanaMenu;

/**
 * @author Vucetic Ivo Clase que representa al controlador que será el encargado
 *         de manejar la funcionalida del programa. Cuenta con las referencias a
 *         cada una de las vistas del programa, Menu, Inscripcion y Arenas.
 *         Tambien cuanta con la referencia al modelo por medio de la clase
 *         Torneo.
 *
 */
public class Controlador implements ActionListener, Observer
{
	private IVistamenu ventanaMenu;
	private IVistaInscripcion ventanaInscripcion;
	private IVistaArenas ventanaArenas;
	private Torneo torneo;
	private int contadorPokemones, contadorEntrenadores;
	private boolean leerAlta, escribirAlta;

	/**
	 * Constructor para inicializar las instancias de las vistas, modelo, variables
	 * como leer y escribir que van a servir para la persistencia del programa.<br>
	 * 
	 * <b>Pre:</b> Ambas entradas deben ser !null.<br>
	 * 
	 * @param leer: Parámetro de tipo Boolean que representa la posibilidad de leer un archivo.<br>
	 * @param escribir: Parámetro de tipo Boolean que representa la posibilidad de escribir en un archivo.<br>
	 */
	public Controlador(boolean leer, boolean escribir)
	{
		this.leerAlta = leer;
		this.escribirAlta = escribir;
		this.ventanaMenu = new VentanaMenu();
		this.ventanaMenu.setActionListener(this);
		this.torneo = Torneo.getInstance();
		this.torneo.addObserver(this);
		this.contadorEntrenadores = torneo.getCantidadEntrenadores();
	}

	/**
	 *Se encarga de escuchar los eventos realizados en cada una de las interfaces.<br>
	 */
	@Override
	public void actionPerformed(ActionEvent evento)
	{
		String comando = evento.getActionCommand();
		if (comando.equalsIgnoreCase("INICIO"))
		{
			this.ventanaMenu.cerrarVentana();
			this.ventanaInscripcion = new VentanaInscripcion(leerAlta);
			this.ventanaInscripcion.setActionListener(this);
		} else if (comando.equalsIgnoreCase("AGREGAR ENTRENADOR"))
		{
			this.agregarEntrenador();
			this.ventanaInscripcion.altaEntrenador();
		} else if (comando.equalsIgnoreCase("AGREGAR POKEMON"))
		{
			this.agregaPokemon();
			this.ventanaInscripcion.altaPokemon(--this.contadorPokemones, this.contadorEntrenadores);
		} else if (comando.equalsIgnoreCase("INICIA TORNEO"))
		{
			if (escribirAlta)
				torneo.getGestionPersistencia().escribeInformacion("Inscripcion.bin", torneo.getListaEntrenadores());
			this.ventanaInscripcion.cerrarVentana();
			this.ventanaArenas = new VentanaArena();
			this.ventanaArenas.setActionListener(this);
			this.torneo.iniciaTorneo();
		}
		this.ventanaInscripcion.actualizarListaEntrenador(this.torneo.getListaEntrenadores().iterator());
	}

	/**
	 * Se encarga de agregar el entrenador correspondiente al torneo y luego muestra el cambio por la vista de Inscripción.<br>
	 * <b>Pos:</b> Se agrega entrenador al torneo.<br>
 	 */
	private void agregarEntrenador()
	{
		String nombre = ventanaInscripcion.getNombreEntrenador();
		Entrenador entrenador = new Entrenador(nombre);
		this.contadorPokemones = entrenador.getCantidadpokemones();
		this.torneo.agregaEntrenador(entrenador);
		this.ventanaInscripcion.agregaLog("Se agrega a " + nombre + " con exito al torneo!! bienvenido!!\n");
		this.contadorEntrenadores--;
	}

	/**
	 * Se encarga de agregar al pokemon correspondiente al torneo y luego muestra el cambio por la vista de Inscripción.<br>
	 * <b>Pos:</b> Se agrega pokemon al torneo.
	 */
	private void agregaPokemon()
	{
		String nombrePokemon = this.ventanaInscripcion.getNombrePokemon();
		String tipo = this.ventanaInscripcion.getTipo();
		String elemento = this.ventanaInscripcion.getTipoElemento();

		Pokemon pokemon = PokemonFactory.getPokemon(nombrePokemon, tipo, elemento);
		int tamaño = this.torneo.getInstance().getListaEntrenadores().size();
		this.torneo.getInstance().getListaEntrenadores().get(tamaño - 1).agregaPokemon(pokemon);
		this.ventanaInscripcion
				.agregaLog("--Se agrega pokemon a la lista de pokemones--\n " + pokemon.toString() + "\n");

	}

	/**
	 *Este método me informará los cambios que sucedan en el modelo para luego informalo a las correspondientes vistas. 
	 *<b>Pos:</b> Se envia el mensaje dado por arg a la vista correspondiente.
	 *@throws IllegalArgumentException(): En el caso de que el observable no sea el torneo.
	 */
	@Override
	public void update(Observable observable, Object arg)
	{
		if ((Torneo) observable != torneo)
			throw new IllegalArgumentException();
		else
		{
			if (arg.toString().equalsIgnoreCase("INICIA TORNEO"))
				this.ventanaArenas.agregaLogSur("\n ---INICIO DEL TORNEO!!---\n");
			else if (arg.toString().equalsIgnoreCase("COMIENZA RONDA"))
				this.ventanaArenas.agregaLogSur("****RONDA" + torneo.getRondaActual() + "****\n");
			else if (arg.toString().equalsIgnoreCase("FIN RONDA"))
				this.ventanaArenas.agregaLogSur("\n ****FIN DE LA RONDA" + torneo.getRondaActual() + "****\n");
			else if (arg.toString().equalsIgnoreCase("FIN TORNEO"))
				this.ventanaArenas.agregaLogSur(
						"\n ****Fin del torneo el ganador es: " + torneo.getGanador().getNombre() + "!!!****\n");
			else if (arg.toString().equalsIgnoreCase("AVISO OESTE"))
				this.ventanaArenas.agregaLogOeste(this.torneo.getMensajeArena());
			else if (arg.toString().equalsIgnoreCase("AVISO ESTE"))
				this.ventanaArenas.agregaLogEste(this.torneo.getMensajeArena());
			else if (arg.toString().equalsIgnoreCase("AVISO CENTRAL"))
				this.ventanaArenas.agregaLogCentral(this.torneo.getMensajeArena());
		}
	}
}
