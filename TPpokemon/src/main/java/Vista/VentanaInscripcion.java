package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Modelo.Entrenador;
import Modelo.Pokemon;

/**
 * @author Vucetic Ivo Clase que representa la vista de la inscripción para el
 *         torneo.<br>
 *
 */
public class VentanaInscripcion extends JFrame implements IVistaInscripcion, KeyListener, ListSelectionListener
{
	private PanelConImagen contentPane;
	private ActionListener actionListener;
	private JPanel panelAlta;
	private JPanel panelAcciones;
	private JPanel panelDatos;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textFieldNombEntren;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnAgregarEntrenador;
	private JPanel panel_4;
	private JLabel lblNewLabel_1;
	private JTextField textNombrePokemon;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JLabel lblNewLabel_2;
	private JPanel panel_9;
	private JTextField textTipo;
	private JPanel panel_11;
	private JPanel panel_12;
	private JLabel lblNewLabel_4;
	private JPanel panel_13;
	private JTextField textElemento;
	private JPanel panel_14;
	private JButton btnAgregaPokemon;
	private JPanel panel_15;
	private JScrollPane scrollPane;
	private JTextArea textAreaAcciones;
	private JPanel panelEntrenadores;
	private JPanel panelPokemones;
	private JScrollPane scrollPane_1;
	private JList<Entrenador> listEntrenadores;
	private JScrollPane scrollPane_2;
	private Recursos recursos = new Recursos();
	private JButton btnIniciaTorneo;
	private DefaultListModel<Entrenador> listModelEntrenador = new DefaultListModel<Entrenador>();
	private JTextArea textAreapokemones;

	/**
	 * Constructor de la ventana, creara los paneles junto con los botones
	 * correspondientes.<br>
	 * 
	 * @param leerAlta: Parámetro de tipo booleano para indicar si se quiere leer
	 *                  inicialmente de un archivo. <br>
	 */
	public VentanaInscripcion(boolean leerAlta)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		this.contentPane = new PanelConImagen();
		this.contentPane.setOpaque(false);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.contentPane.setFondo(recursos.getFndVentanaInsV1());
		setContentPane(this.contentPane);

		// Panel para hacer el alta de los entrenadores y pokemones.
		this.panelAlta = new JPanel();
		this.panelAlta.setOpaque(false);
		this.panelAlta.setBackground(Color.GRAY);
		this.panelAlta.setBorder(
				new TitledBorder(null, "Ficha de Inscripcion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.contentPane.add(this.panelAlta, BorderLayout.WEST);
		this.panelAlta.setPreferredSize(new Dimension(this.getWidth() / 2 - 10, 0));
		this.panelAlta.setLayout(new GridLayout(8, 0, 0, 0));

		this.panel = new JPanel();
		this.panelAlta.add(this.panel);
		this.panel.setLayout(new GridLayout(0, 2, 0, 0));

		this.panel_1 = new JPanel();
		this.panel_1.setOpaque(false);
		this.panel.add(this.panel_1);

		this.lblNewLabel = new JLabel("Nombre entrenador :");
		this.lblNewLabel.setFont(new Font("Square721 BT", Font.BOLD, 12));
		this.panel_1.add(this.lblNewLabel);

		this.panel_2 = new JPanel();
		this.panel_2.setOpaque(false);
		this.panel.add(this.panel_2);

		this.textFieldNombEntren = new JTextField();
		this.panel_2.add(this.textFieldNombEntren);
		this.textFieldNombEntren.setColumns(10);
		this.textFieldNombEntren.addKeyListener(this);
		this.textFieldNombEntren.setEnabled(!leerAlta);

		this.panel_3 = new JPanel();
		this.panel_3.setOpaque(false);
		this.panelAlta.add(this.panel_3);

		// Boton para agregar entrenador.
		this.btnAgregarEntrenador = new JButton("Agregar");
		this.btnAgregarEntrenador.setEnabled(false);
		this.btnAgregarEntrenador.setActionCommand("AGREGAR ENTRENADOR");
		this.btnAgregarEntrenador.setFont(new Font("Square721 BT", Font.BOLD, 12));
		this.panel_3.add(this.btnAgregarEntrenador);

		this.panel_4 = new JPanel();
		this.panelAlta.add(this.panel_4);
		this.panel_4.setLayout(new GridLayout(0, 2, 0, 0));

		this.panel_5 = new JPanel();
		this.panel_4.add(this.panel_5);

		this.lblNewLabel_1 = new JLabel("Nombre Pokemon:");
		this.lblNewLabel_1.setFont(new Font("Square721 BT", Font.BOLD, 12));
		this.panel_5.add(this.lblNewLabel_1);

		this.panel_6 = new JPanel();
		this.panel_4.add(this.panel_6);

		this.textNombrePokemon = new JTextField();
		this.textNombrePokemon.setEnabled(false);
		this.panel_6.add(this.textNombrePokemon);
		this.textNombrePokemon.setColumns(10);
		this.textNombrePokemon.addKeyListener(this);

		this.panel_7 = new JPanel();
		this.panelAlta.add(this.panel_7);
		this.panel_7.setLayout(new GridLayout(0, 2, 0, 0));

		this.panel_8 = new JPanel();
		this.panel_7.add(this.panel_8);

		this.lblNewLabel_2 = new JLabel("Tipo");
		this.lblNewLabel_2.setFont(new Font("Square721 BT", Font.BOLD, 12));
		this.panel_8.add(this.lblNewLabel_2);

		this.panel_9 = new JPanel();
		this.panel_7.add(this.panel_9);

		this.textTipo = new JTextField();
		this.textTipo.setEnabled(false);
		this.textTipo.setColumns(10);
		this.panel_9.add(this.textTipo);
		this.textTipo.addKeyListener(this);

		this.panel_11 = new JPanel();
		this.panelAlta.add(this.panel_11);
		this.panel_11.setLayout(new GridLayout(0, 2, 0, 0));

		this.panel_12 = new JPanel();
		this.panel_11.add(this.panel_12);

		this.lblNewLabel_4 = new JLabel("Tipo Elemento");
		this.lblNewLabel_4.setFont(new Font("Square721 BT", Font.BOLD, 12));
		this.panel_12.add(this.lblNewLabel_4);

		this.panel_13 = new JPanel();
		this.panel_11.add(this.panel_13);

		this.textElemento = new JTextField();
		this.textElemento.setEnabled(false);
		this.textElemento.setColumns(10);
		this.panel_13.add(this.textElemento);
		this.textElemento.addKeyListener(this);

		this.panel_14 = new JPanel();
		this.panel_14.setOpaque(false);
		this.panelAlta.add(this.panel_14);

		// Boton para agregar pokemon.
		this.btnAgregaPokemon = new JButton("Agregar");
		this.btnAgregaPokemon.setActionCommand("AGREGAR POKEMON");
		this.btnAgregaPokemon.setEnabled(false);
		this.btnAgregaPokemon.setFont(new Font("Square721 BT", Font.BOLD, 12));
		this.panel_14.add(this.btnAgregaPokemon);

		this.panel_15 = new JPanel();
		this.panel_15.setOpaque(false);
		this.panelAlta.add(this.panel_15);

		this.btnIniciaTorneo = new JButton("Inicio Torneo");
		this.btnIniciaTorneo.setActionCommand("INICIA TORNEO");
		this.btnIniciaTorneo.setFont(new Font("Square721 BT", Font.BOLD, 12));
		this.panel_15.add(this.btnIniciaTorneo);
		this.btnIniciaTorneo.setEnabled(leerAlta);

		// Panel en el que nos mostrará los cambios que se realizen en la ventana.
		this.panelAcciones = new JPanel();
		this.panelAcciones.setOpaque(false);
		this.panelAcciones.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		this.contentPane.add(this.panelAcciones, BorderLayout.SOUTH);
		this.panelAcciones.setPreferredSize(new Dimension(0, this.getHeight() * 1 / 4));
		this.panelAcciones.setLayout(new BorderLayout(0, 0));

		this.scrollPane = new JScrollPane();
		this.panelAcciones.add(this.scrollPane, BorderLayout.CENTER);

		this.textAreaAcciones = new JTextArea();
		this.scrollPane.setViewportView(this.textAreaAcciones);

		this.panelDatos = new JPanel();
		this.panelDatos.setOpaque(false);
		this.contentPane.add(this.panelDatos, BorderLayout.CENTER);
		this.panelDatos.setLayout(new GridLayout(2, 0, 0, 0));

		this.panelEntrenadores = new JPanel();
		this.panelEntrenadores.setOpaque(false);
		this.panelEntrenadores
				.setBorder(new TitledBorder(null, "Entrenadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelDatos.add(this.panelEntrenadores);
		this.panelEntrenadores.setLayout(new BorderLayout(0, 0));

		this.scrollPane_1 = new JScrollPane();
		this.panelEntrenadores.add(this.scrollPane_1, BorderLayout.CENTER);

		this.listEntrenadores = new JList<Entrenador>();
		this.scrollPane_1.setViewportView(this.listEntrenadores);
		this.listEntrenadores.addListSelectionListener(this);

		this.panelPokemones = new JPanel();
		this.panelPokemones.setOpaque(false);
		this.panelPokemones.setBorder(
				new TitledBorder(null, "Pokemones por entrenador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelDatos.add(this.panelPokemones);
		this.panelPokemones.setLayout(new BorderLayout(0, 0));

		this.scrollPane_2 = new JScrollPane();
		this.panelPokemones.add(this.scrollPane_2, BorderLayout.CENTER);

		this.textAreapokemones = new JTextArea();
		this.scrollPane_2.setViewportView(this.textAreapokemones);

		this.listEntrenadores.setModel(listModelEntrenador);

		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void setActionListener(ActionListener actionListener)
	{
		this.actionListener = actionListener;
		this.btnAgregarEntrenador.addActionListener(actionListener);
		this.btnAgregaPokemon.addActionListener(actionListener);
		this.btnIniciaTorneo.addActionListener(actionListener);
	}

	@Override
	public void cerrarVentana()
	{
		this.dispose();
	}

	@Override
	public String getNombreEntrenador()
	{
		return this.textFieldNombEntren.getText();
	}

	@Override
	public String getNombrePokemon()
	{
		return this.textNombrePokemon.getText();
	}

	@Override
	public String getTipo()
	{
		return this.textTipo.getText();
	}

	@Override
	public String getTipoElemento()
	{
		return this.textElemento.getText();
	}

	@Override
	public void keyPressed(KeyEvent arg0)
	{
	}

	/**
	 * Dependiendo de los parámetros que se ingresen se habilitara o no el boton
	 * para poder agregar al pokemon. No hay ninguna restriccion para con el nombre,
	 * si para con el tipo que debe ser comun o legendario y el tipo elemento debe
	 * ser hada,roca,fuego,agua o hielo.
	 * 
	 */
	@Override
	public void keyReleased(KeyEvent arg0)
	{
		String nombre = "", tipo = "", elemento = "";
		boolean condicion, condicion1, condicion2;

		if (arg0.getSource() == this.textFieldNombEntren)
		{
			nombre = this.textFieldNombEntren.getText();
			condicion = !nombre.equals("");
			this.btnAgregarEntrenador.setEnabled(condicion);

		} else
		{
			nombre = this.textNombrePokemon.getText();
			tipo = this.textTipo.getText();
			elemento = this.getTipoElemento();

			condicion1 = tipo.equalsIgnoreCase("comun") || tipo.equalsIgnoreCase("legendario");
			condicion2 = elemento.equalsIgnoreCase("hada") || elemento.equalsIgnoreCase("hielo")
					|| elemento.equalsIgnoreCase("agua") || elemento.equalsIgnoreCase("fuego")
					|| elemento.equalsIgnoreCase("roca") || elemento.equals("");

			this.btnAgregaPokemon.setEnabled(!nombre.equals("") && condicion1 && condicion2);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
	}

	@Override
	public void altaEntrenador()
	{
		this.textFieldNombEntren.setText("");
		this.textFieldNombEntren.setEnabled(false);
		this.btnAgregarEntrenador.setEnabled(false);
		this.textNombrePokemon.setEnabled(true);
		this.textTipo.setEnabled(true);
		this.textElemento.setEnabled(true);
	}

	/**
	 * Si ya se agregaron todos los pokemones para un entrenador y todavia tengo
	 * entrenadores para ingresar al torneo se me habilita la posibilidad de agregar
	 * mas entrenadores y se bloquea la de ingresar pokemones. En cambio si ya
	 * ingrese todos los pokemones para ese entrenador y llegue a la cantidad maxima
	 * para el torneo, se desabilitara todo el panel, pero se habilita la
	 * posibilidad de iniciar el torneo.
	 * 
	 */
	@Override
	public void altaPokemon(int contP, int contE)
	{
		if (contP <= 0 && contE > 0)
		{
			this.textFieldNombEntren.setEnabled(true);
			this.btnAgregarEntrenador.setEnabled(true);
			this.textNombrePokemon.setEnabled(false);
			this.textTipo.setEnabled(false);
			this.textElemento.setEnabled(false);
			this.btnAgregaPokemon.setEnabled(false);
		} else if (contP <= 0 && contE == 0)
		{
			this.textNombrePokemon.setEnabled(false);
			this.textTipo.setEnabled(false);
			this.textElemento.setEnabled(false);
			this.btnIniciaTorneo.setEnabled(true);
			this.btnAgregaPokemon.setEnabled(false);
		}
		this.textNombrePokemon.setText("");
		this.textTipo.setText("");
		this.textElemento.setText("");

	}

	/**
	 * Dependiendo del entrenador que seleccione en la lista dada en la ventana, me
	 * mostrará los pokemones que tiene el entrenador en el detalle de los pokemones
	 * dispuesto en la vista.
	 */
	@Override
	public void valueChanged(ListSelectionEvent arg0)
	{
		Entrenador p = (Entrenador) this.listEntrenadores.getSelectedValue();
		if (p != null)
		{
			this.textAreapokemones.setText(p.detallePokemones());
		}
	}

	/**
	 * Se encarga de actualizar la lista de los entrenadores y se vuelve a dibujar
	 * la pantalla para mostrar los cambios.
	 */
	@Override
	public void actualizarListaEntrenador(Iterator<Entrenador> iterator)
	{
		this.listModelEntrenador.clear();

		while (iterator.hasNext())
			this.listModelEntrenador.addElement(iterator.next());
		this.repaint();
	}

	@Override
	public void agregaLog(String lineaTexto)
	{
		this.textAreaAcciones.append(lineaTexto);
	}

}
