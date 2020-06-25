package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Entrenador;
import Modelo.Pokemon;
import Modelo.PokemonFactory;
import Modelo.Torneo;
import Vista.IVistaInscripcion;
import Vista.IVistamenu;
import Vista.VentanaInscripcion;
import Vista.VentanaMenu;

public class Controlador implements ActionListener
{
	private IVistamenu ventanaMenu;
	private IVistaInscripcion ventanaInscripcion;
	private Torneo torneo;
	private int contadorPokemones, contadorEntrenadores;

	public Controlador()
	{
		this.ventanaMenu = new VentanaMenu();
		this.ventanaMenu.setActionListener(this);
		this.torneo = Torneo.getInstance();
		this.contadorEntrenadores = torneo.getCantidadEntrenadores();
	}

	public void setVentanaMenu(IVistamenu ventanaMenu)
	{
		this.ventanaMenu = ventanaMenu;
		this.ventanaMenu.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evento)
	{
		String comando = evento.getActionCommand();
		if (comando.equalsIgnoreCase("INICIO"))
		{
			this.ventanaMenu.cerrarVentana();
			this.ventanaInscripcion = new VentanaInscripcion();
			this.ventanaInscripcion.setActionListener(this);
		} else if (comando.equalsIgnoreCase("AGREGAR ENTRENADOR"))
		{
			this.agregarEntrenador();
			this.ventanaInscripcion.altaEntrenador();
		} else if (comando.equalsIgnoreCase("AGREGAR POKEMON"))
		{
			this.agregaPokemon();
			this.ventanaInscripcion.altaPokemon(--this.contadorPokemones, this.contadorEntrenadores);
		} else if (comando.equalsIgnoreCase("SI ELEMENTO"))
			this.ventanaInscripcion.habilitaElemento();
		else if (comando.equalsIgnoreCase("NO ELEMENTO"))
			this.ventanaInscripcion.deshabilitaElemento();
		else if (comando.equalsIgnoreCase("INICIA TORNEO"))
		{

		}
		this.ventanaInscripcion.actualizarListaEntrenador(this.torneo.getListaEntrenadores().iterator());
	}

	private void agregarEntrenador()
	{
		String nombre = ventanaInscripcion.getNombreEntrenador();
		Entrenador entrenador = new Entrenador(nombre);
		this.contadorPokemones = entrenador.getCantidadpokemones();
		this.torneo.agregaEntrenador(entrenador);
		this.ventanaInscripcion.agregaLog("Se agrega a " + nombre + " con exito al torneo!! bienvenido!!\n");
		this.contadorEntrenadores--;
	}

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

}
