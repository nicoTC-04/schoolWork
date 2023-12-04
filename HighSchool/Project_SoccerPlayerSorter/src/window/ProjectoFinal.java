package window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class ProjectoFinal {

	public static int count = 0;
	public static int total = 0;
	private JFrame frame;
	private JTextField nomTfld;
	private JTextField paisTfld;
	private JLabel posLbl;
	private JTextField posTfld;
	private JLabel edadLbl;
	private JTextField edadTfld;
	private JLabel grupoLbl;
	private JTextField grupoTfld;
	private JLabel numLbl;
	private JTextField numTfld;
	private JLabel imgLbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Jugadores y = new Jugadores();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectoFinal window = new ProjectoFinal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProjectoFinal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("recursos\\logo.png"));
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 458, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel nomLbl = new JLabel("Nombre:");
		nomLbl.setBounds(259, 53, 63, 14);
		frame.getContentPane().add(nomLbl);
		
		nomTfld = new JTextField();
		nomTfld.setEditable(false);
		nomTfld.setBounds(326, 53, 108, 20);
		frame.getContentPane().add(nomTfld);
		nomTfld.setColumns(10);
		nomTfld.setText(Jugadores.getNombres()[count]);
		
		JLabel paisLbl = new JLabel("Pais:");
		paisLbl.setBounds(259, 88, 63, 14);
		frame.getContentPane().add(paisLbl);
		
		paisTfld = new JTextField();
		paisTfld.setText((String) null);
		paisTfld.setEditable(false);
		paisTfld.setColumns(10);
		paisTfld.setBounds(326, 88, 108, 20);
		frame.getContentPane().add(paisTfld);
		paisTfld.setText(Jugadores.getPais()[count]);
		
		posLbl = new JLabel("Posicion:");
		posLbl.setBounds(259, 123, 63, 14);
		frame.getContentPane().add(posLbl);
		
		posTfld = new JTextField();
		posTfld.setText((String) null);
		posTfld.setEditable(false);
		posTfld.setColumns(10);
		posTfld.setBounds(326, 123, 108, 20);
		frame.getContentPane().add(posTfld);
		posTfld.setText(Jugadores.getPos()[count]);
		
		edadLbl = new JLabel("Edad:");
		edadLbl.setBounds(259, 158, 63, 14);
		frame.getContentPane().add(edadLbl);
		
		edadTfld = new JTextField();
		edadTfld.setText((String) null);
		edadTfld.setEditable(false);
		edadTfld.setColumns(10);
		edadTfld.setBounds(326, 158, 108, 20);
		frame.getContentPane().add(edadTfld);
		edadTfld.setText(Jugadores.getEdad()[count]);
		
		grupoLbl = new JLabel("grupo:");
		grupoLbl.setBounds(259, 190, 63, 20);
		frame.getContentPane().add(grupoLbl);
		
		grupoTfld = new JTextField();
		grupoTfld.setText((String) null);
		grupoTfld.setEditable(false);
		grupoTfld.setColumns(10);
		grupoTfld.setBounds(326, 193, 108, 20);
		frame.getContentPane().add(grupoTfld);
		grupoTfld.setText(Jugadores.getGrupo()[count]);
		
		numLbl = new JLabel("Numero:");
		numLbl.setBounds(259, 228, 63, 14);
		frame.getContentPane().add(numLbl);
		
		numTfld = new JTextField();
		numTfld.setText((String) null);
		numTfld.setEditable(false);
		numTfld.setColumns(10);
		numTfld.setBounds(326, 228, 108, 20);
		frame.getContentPane().add(numTfld);
		numTfld.setText(Jugadores.getNumero()[count]);
		
		imgLbl = new JLabel("");
		imgLbl.setIcon(new ImageIcon("recursos\\"+Jugadores.imgName(count)));
		imgLbl.setBounds(59, 53, 148, 195);
		frame.getContentPane().add(imgLbl);
		
		JLabel pregLbl = new JLabel("Tienes la carta?");
		pregLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pregLbl.setBounds(167, 325, 131, 45);
		frame.getContentPane().add(pregLbl);
		
		JButton siBtn = new JButton("Si");
		JButton noBtn = new JButton("No");
		siBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				total++;
				if(count!=4) {
					count++;
					nomTfld.setText(Jugadores.getNombres()[count]);
					paisTfld.setText(Jugadores.getPais()[count]);
					posTfld.setText(Jugadores.getPos()[count]);
					edadTfld.setText(Jugadores.getEdad()[count]);
					grupoTfld.setText(Jugadores.getGrupo()[count]);
					numTfld.setText(Jugadores.getNumero()[count]);
					imgLbl.setIcon(new ImageIcon("recursos\\"+Jugadores.imgName(count)));
				} else {
					nomTfld.setVisible(false);
					nomLbl.setVisible(false);
					paisTfld.setVisible(false);
					paisLbl.setVisible(false);
					posTfld.setVisible(false);
					posLbl.setVisible(false);
					edadTfld.setVisible(false);
					edadLbl.setVisible(false);
					grupoTfld.setVisible(false);
					grupoLbl.setVisible(false);
					numTfld.setVisible(false);
					numLbl.setVisible(false);
					noBtn.setVisible(false);
					siBtn.setVisible(false);
					if(total==4) {
						pregLbl.setText("Te falta "+(5-total)+" jugador");
					} else {
						pregLbl.setText("Te faltan "+(5-total)+" jugadores");
					}
					imgLbl.setBounds(120, 40, 221, 275);
					imgLbl.setIcon(new ImageIcon("recursos\\Album.jpg"));
				}
			}
		});
		
		siBtn.setBounds(118, 360, 89, 23);
		frame.getContentPane().add(siBtn);
		
		
		noBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(count!=4) {
					count++;
					nomTfld.setText(Jugadores.getNombres()[count]);
					paisTfld.setText(Jugadores.getPais()[count]);
					posTfld.setText(Jugadores.getPos()[count]);
					edadTfld.setText(Jugadores.getEdad()[count]);
					grupoTfld.setText(Jugadores.getGrupo()[count]);
					numTfld.setText(Jugadores.getNumero()[count]);
					imgLbl.setIcon(new ImageIcon("recursos\\"+Jugadores.imgName(count)));
				} else {
					nomTfld.setVisible(false);
					nomLbl.setVisible(false);
					paisTfld.setVisible(false);
					paisLbl.setVisible(false);
					posTfld.setVisible(false);
					posLbl.setVisible(false);
					edadTfld.setVisible(false);
					edadLbl.setVisible(false);
					grupoTfld.setVisible(false);
					grupoLbl.setVisible(false);
					numTfld.setVisible(false);
					numLbl.setVisible(false);
					noBtn.setVisible(false);
					siBtn.setVisible(false);
					if(total==4) {
						pregLbl.setText("Te falta "+(5-total)+" jugador");
					} else {
						pregLbl.setText("Te faltan "+(5-total)+" jugadores");
					}
					imgLbl.setBounds(120, 40, 221, 275);
					imgLbl.setIcon(new ImageIcon("recursos\\Album.jpg"));
				}
			}
		});
		noBtn.setBounds(259, 360, 89, 23);
		frame.getContentPane().add(noBtn);
	}
}