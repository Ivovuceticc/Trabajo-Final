package Vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaMenu extends JFrame implements IVistamenu, MouseListener
{
	private static final long serialVersionUID = 1L;
	private PanelConImagen contentPane;
	private Recursos recursos = new Recursos();
	private JPanel panelPrincipal;
	private JPanel panel_1;
	private JPanel panelMedio;
	private JPanel panel;
	private JPanel panelBotones;
	private JButton btnInicio;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JButton btnReglas;
	private JPanel panel_3;
	private ActionListener actionListener;

	public VentanaMenu()
	{

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 348);
		this.contentPane = new PanelConImagen();
		this.contentPane.setOpaque(false);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.contentPane.setFondo(recursos.getFndVentanaV1());

		setContentPane(this.contentPane);

		this.panelPrincipal = new JPanel();
		this.panelPrincipal.setOpaque(false);
		this.contentPane.add(this.panelPrincipal, BorderLayout.CENTER);
		this.panelPrincipal.setLayout(new GridLayout(0, 3, 0, 0));

		this.panel_1 = new JPanel();
		this.panel_1.setOpaque(false);
		this.panelPrincipal.add(this.panel_1);

		this.panelMedio = new JPanel();
		this.panelMedio.setOpaque(false);
		this.panelPrincipal.add(this.panelMedio);
		this.panelMedio.setLayout(new GridLayout(3, 0, 0, 0));

		this.panel = new JPanel();
		this.panel.setOpaque(false);
		this.panelMedio.add(this.panel);

		this.panelBotones = new JPanel();
		this.panelBotones.setOpaque(false);
		this.panelMedio.add(this.panelBotones);
		this.panelBotones.setLayout(new GridLayout(3, 0, 0, 0));

		this.panel_2 = new JPanel();
		this.panel_2.setOpaque(false);
		this.panelBotones.add(this.panel_2);

		this.btnInicio = new JButton("Inicio\r\n");
		this.btnInicio.setActionCommand("INICIO");
		this.btnInicio.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
		this.panel_2.add(this.btnInicio);

		this.lblNewLabel = new JLabel("");
		this.panelBotones.add(this.lblNewLabel);

		this.panel_3 = new JPanel();
		this.panel_3.setOpaque(false);
		this.panelBotones.add(this.panel_3);

		this.btnReglas = new JButton("Reglas\r\n");
		this.btnReglas.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		this.panel_3.add(this.btnReglas);
		this.btnReglas.addMouseListener(this);

		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

	}

	@Override
	public void setActionListener(ActionListener actionListener)
	{
		btnInicio.addActionListener(actionListener);
		this.actionListener = actionListener;
	}
	
	@Override
	public void cerrarVentana()
	{
		this.dispose();
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		JOptionPane.showMessageDialog(this, "****Bienvenido al torneo pokémon!!!!****\r\n"
				+ "Contamos con un cupo máximo de 8 participantes. Cada uno de los participantes a la hora de la inscripcion podrá registrar un máximo de 4 pokemones.\r\n"
				+ "El torneo consta de  4 rondas en las que por cada batalla se debe presentar un pokémon y una carta hechizo que puede utilizar contra el entrenador rival.\r\n"
				+ "Al finalizar la batalla el entrenador ganador tendrá la posibilidad de elegir un premio y pasará a la siguiente ronda, mientras que el perdedor quedará eliminado del torneo.\r\n"
				+ "****QUE TENGAN SUERTE!!!**** ");
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}
}
