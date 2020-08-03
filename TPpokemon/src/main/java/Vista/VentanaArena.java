package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;

public class VentanaArena extends JFrame implements IVistaArenas
{
	private JPanel contentPane;
	private JPanel panelOeste;
	private JPanel panelCentral;
	private JPanel panelEste;
	private JScrollPane scrollPane;
	private JTextArea textAreaOeste;
	private JScrollPane scrollPane_1;
	private JTextArea textArea_Central;
	private JScrollPane scrollPane_2;
	private JTextArea textArea_Este;
	private ActionListener actionListener;
	private JPanel panelSur;
	private JPanel panelDetalles;
	private JScrollPane scrollPane_3;
	private JTextArea textArea_Sur;
	private JPanel panel;

	public VentanaArena()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 600);

		this.panelOeste = new JPanel();
		this.panelOeste
				.setBorder(new TitledBorder(null, "Arena Oeste", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(this.panelOeste, BorderLayout.WEST);
		this.panelOeste.setPreferredSize(new Dimension((this.getBounds().width * 1 / 3) - 10, 600));
		this.panelOeste.setLayout(new BorderLayout(0, 0));

		this.scrollPane = new JScrollPane();
		this.panelOeste.add(this.scrollPane);

		this.textAreaOeste = new JTextArea();
		this.scrollPane.setViewportView(this.textAreaOeste);

		this.panelCentral = new JPanel();
		this.panelCentral
				.setBorder(new TitledBorder(null, "Arena Central", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new BorderLayout(0, 0));

		this.scrollPane_1 = new JScrollPane();
		this.panelCentral.add(this.scrollPane_1, BorderLayout.CENTER);

		this.textArea_Central = new JTextArea();
		this.scrollPane_1.setViewportView(this.textArea_Central);

		this.panelEste = new JPanel();
		this.panelEste
				.setBorder(new TitledBorder(null, "Arena Este", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(this.panelEste, BorderLayout.EAST);
		this.panelEste.setPreferredSize(new Dimension((this.getBounds().width * 1 / 3) - 10, 600));
		this.panelEste.setLayout(new BorderLayout(0, 0));

		this.scrollPane_2 = new JScrollPane();
		this.panelEste.add(this.scrollPane_2, BorderLayout.CENTER);

		this.textArea_Este = new JTextArea();
		this.scrollPane_2.setViewportView(this.textArea_Este);

		this.panelSur = new JPanel();
		getContentPane().add(this.panelSur, BorderLayout.SOUTH);
		this.panelSur.setPreferredSize(new Dimension(0, 150));
		this.panelSur.setLayout(new GridLayout(0, 2, 0, 0));

		this.panelDetalles = new JPanel();
		this.panelDetalles.setBorder(
				new TitledBorder(null, "Informacion Torneo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelSur.add(this.panelDetalles);
		this.panelDetalles.setLayout(new BorderLayout(0, 0));

		this.scrollPane_3 = new JScrollPane();
		this.panelDetalles.add(this.scrollPane_3, BorderLayout.CENTER);

		this.textArea_Sur = new JTextArea();
		this.scrollPane_3.setViewportView(this.textArea_Sur);

		this.panel = new JPanel();
		this.panelSur.add(this.panel);

		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void setActionListener(ActionListener actionListener)
	{
		this.actionListener = actionListener;
	}

	@Override
	public void agregaLogOeste(String lineaTexto)
	{
		this.textAreaOeste.append(lineaTexto + "\n");
	}

	@Override
	public void agregaLogCentral(String lineaTexto)
	{
		this.textArea_Central.append(lineaTexto + "\n");
	}

	@Override
	public void agregaLogEste(String lineaTexto)
	{
		this.textArea_Este.append(lineaTexto + "\n");
	}

	public void agregaLogSur(String lineaTexto)
	{
		this.textArea_Sur.append(lineaTexto + "\n");
	}

}
