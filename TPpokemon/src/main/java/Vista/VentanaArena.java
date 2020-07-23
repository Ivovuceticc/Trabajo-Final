package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

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

	public VentanaArena()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 600);
		
		this.panelOeste = new JPanel();
		this.panelOeste.setBorder(new TitledBorder(null, "Arena Oeste", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(this.panelOeste, BorderLayout.WEST);
		this.panelOeste.setPreferredSize(new Dimension((this.getBounds().width* 1/3) - 10 , 600));
		this.panelOeste.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panelOeste.add(this.scrollPane, BorderLayout.CENTER);
		
		this.textAreaOeste = new JTextArea();
		this.scrollPane.setViewportView(this.textAreaOeste);
		
		this.panelCentral = new JPanel();
		this.panelCentral.setBorder(new TitledBorder(null, "Arena Central", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane_1 = new JScrollPane();
		this.panelCentral.add(this.scrollPane_1, BorderLayout.CENTER);
		
		this.textArea_Central = new JTextArea();
		this.scrollPane_1.setViewportView(this.textArea_Central);
		
		this.panelEste = new JPanel();
		this.panelEste.setBorder(new TitledBorder(null, "Arena Este", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(this.panelEste, BorderLayout.EAST);
		this.panelEste.setPreferredSize(new Dimension((this.getBounds().width* 1/3) - 10 , 600));
		this.panelEste.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane_2 = new JScrollPane();
		this.panelEste.add(this.scrollPane_2, BorderLayout.CENTER);
		
		this.textArea_Este = new JTextArea();
		this.scrollPane_2.setViewportView(this.textArea_Este);
		
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
	public void agregaLog(String lineaTexto)
	{
		
	}

}
