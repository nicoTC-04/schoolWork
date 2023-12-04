package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class pedidoForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pedidoForm frame = new pedidoForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pedidoForm() {
		
		//cursor
		addMouseMotionListener(new MouseMotionListener() {
		    @Override
		    public void mouseMoved(MouseEvent e) {
		    	Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
		    	setCursor(cursor);	
		    }
		    
		    //metodo Obligatorio que no importa
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//iniciar el frame
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("recursos\\Icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 50, 450, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Imagen de logo
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon("recursos\\Logo.png"));
		lblLogo.setBounds(59, 18, 300, 145);
		getContentPane().add(lblLogo);
		
		//titulo del formulario
		JLabel titulo = new JLabel("Nuevo Pedido");
		titulo.setBounds(25, 170, 120, 30);
		titulo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(titulo);
		
		//tipo de pedido
		JLabel tipo = new JLabel("Tipo:");
		tipo.setBounds(25, 210, 70, 20);
		tipo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(tipo);
		
		//botones de tipo radio para el tipo de pedido
		JRadioButton tallerRadio = new JRadioButton("Taller");
		tallerRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tallerRadio.setBackground(Color.WHITE);
		tallerRadio.setActionCommand("Taller");
		tallerRadio.setBounds(75, 207, 60, 30);
		Cursor(tallerRadio);
		contentPane.add(tallerRadio);
		
		JRadioButton traspasoRadio = new JRadioButton("Traspaso");
		traspasoRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		traspasoRadio.setBackground(Color.WHITE);
		traspasoRadio.setActionCommand("Traspaso");
		traspasoRadio.setBounds(150, 207, 75, 30);
		Cursor(traspasoRadio);
		contentPane.add(traspasoRadio);
		
		ButtonGroup radios = new ButtonGroup();
	    radios.add(tallerRadio);
	    radios.add(traspasoRadio);
		
	    //Label y text para el codigo del pedido
		JLabel codigo = new JLabel("Codigo:");
		codigo.setBounds(25, 250, 70, 20);
		codigo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(codigo);
		
		JTextField txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtCodigo.setForeground(Color.GRAY);
		txtCodigo.setText("Codigo");
		txtCodigo.setBounds(75, 252, 100, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setBorder(new LineBorder(Color.GRAY,1));
		
		//Label y dropdown para el "de" del pedido
		JLabel de = new JLabel("De:");
		de.setBounds(25, 290, 70, 20);
		de.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(de);
		
		String deLista[] = { "Esfera", "Citadel", "Cumbres", "Fashion", "PFSA", "Multiplaza", "Paseo LaFe" };
		JComboBox deBox = new JComboBox(deLista);
		deBox.setBounds(75, 292, 100, 20);
		deBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(deBox);
		Cursor(deBox);
		
		//Label y dropdown para el "para" del pedido
		JLabel para = new JLabel("Para:");
		para.setBounds(25, 330, 70, 20);
		para.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(para);
		
		String paraLista[] = { "Esfera", "Citadel", "Cumbres", "Fashion", "PFSA", "Multiplaza", "Paseo LaFe" };
		JComboBox paraBox = new JComboBox(paraLista);
		paraBox.setBounds(75, 332, 100, 20);
		paraBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(paraBox);
		Cursor(paraBox);
		
		//Label y texts para la fecha del pedido
		JLabel fecha = new JLabel("Fecha:");
		fecha.setBounds(25, 370, 70, 20);
		fecha.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(fecha);
		
		JTextField txtDia = new JTextField();
		txtDia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtDia.setForeground(Color.GRAY);
		txtDia.setText("Dia");
		txtDia.setBounds(75, 372, 35, 20);
		getContentPane().add(txtDia);
		txtDia.setColumns(10);
		txtDia.setBorder(new LineBorder(Color.GRAY,1));
		
		JLabel slash = new JLabel("/");
		slash.setBounds(112, 372, 5, 20);
		slash.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(slash);
		
		JTextField txtMes = new JTextField();
		txtMes.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtMes.setForeground(Color.GRAY);
		txtMes.setText("Mes");
		txtMes.setBounds(120, 372, 35, 20);
		getContentPane().add(txtMes);
		txtMes.setColumns(10);
		txtMes.setBorder(new LineBorder(Color.GRAY,1));
		
		JLabel slash2 = new JLabel("/");
		slash2.setBounds(157, 372, 5, 20);
		slash2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(slash2);
		
		JTextField txtAnio = new JTextField();
		txtAnio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtAnio.setForeground(Color.GRAY);
		txtAnio.setText("Año");
		txtAnio.setBounds(165, 372, 35, 20);
		getContentPane().add(txtAnio);
		txtAnio.setColumns(10);
		txtAnio.setBorder(new LineBorder(Color.GRAY,1));
		
		//Boton de guardar pedido
		JButton guardarPedido = new JButton("Guardar Pedido");
		guardarPedido.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		guardarPedido.setBounds(145, 450, 150, 30);
		contentPane.add(guardarPedido);
		Cursor(guardarPedido);
		
		//evento cuando se le da click al boton
		guardarPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean radioSelected = (tallerRadio.isSelected() || traspasoRadio.isSelected());
				
				if(!radioSelected  || (txtDia.getText() == "Dia") || (txtCodigo.getText() == "Codigo") || (txtMes.getText() == "Mes") || (txtAnio.getText() == "Año")) {
					JOptionPane.showMessageDialog(null, "Tienes que editar todos los campos para guardar el pedido");
				} else {
					//arreglos para ver si algun dato introducido esta mal
					boolean[] errors = {false, false, false, false};
					Component[] errorsComp = {txtCodigo, txtDia, txtMes, txtAnio};
					
					//validaciones paara probrar que sean ints
					try {
						Integer.parseInt(txtCodigo.getText());
						
					} catch(NumberFormatException j) {
						errors[0] = true;
					}
					
					try {
						Integer.parseInt(txtDia.getText());
	
					} catch(NumberFormatException j) {
						errors[1] = true;
					}
					
					try {
						Integer.parseInt(txtMes.getText());
						
					} catch(NumberFormatException j) {
						errors[2] = true;
					}
					
					try {
						Integer.parseInt(txtAnio.getText());
						
					} catch(NumberFormatException j) {
						errors[3] = true;
					}
					
					
					//validación de codigo
					if(!errors[0]) {
						if(txtCodigo.getText().length()>=3 && txtCodigo.getText().length()<=6 && (Integer.parseInt(txtCodigo.getText()) % 1) == 0) {
							//para comprobar que si sea un numero entre 3 y 6
						} else {
							errors[0] = true;
						}
					}
					
					if(errors[0]) {
						JOptionPane.showMessageDialog(null, "El codigo es incorrecto, tiene que ser un numero entero de entre 3 y 6 digitos");
					}
					
					//Validacion de año
					boolean year = false;
					if(!errors[3]) {
						if(Integer.parseInt(txtAnio.getText()) == 2021 || Integer.parseInt(txtAnio.getText()) == 2022) {
							year = true;
						} else {
							errors[3] = true;
						}
					}
					if(errors[3]) {
						JOptionPane.showMessageDialog(null, "El año es incorrecto, tiene que ser 2021 o 2022");
					}
					
					//validacion de mes
					boolean mes = false;
					if(!errors[2]) {
						if(Integer.parseInt(txtMes.getText()) > 0 && Integer.parseInt(txtMes.getText()) <= 12 && (Integer.parseInt(txtMes.getText()) % 1) == 0) {
							mes = true;
						} else {
							errors[2] = true;
						}
					}
					if(errors[2]) {
						JOptionPane.showMessageDialog(null, "El mes es incorrecto, tiene que ser un entero entre 1 y 12");
					}
					
					//validacion de dia
					boolean dia = false;
					int expectedMaxDay = 0;
					
					if(!errors[1]) {
						
						if(mes) {
							if(Integer.parseInt(txtMes.getText()) == 2) {
								expectedMaxDay = 28;
							} else if(Integer.parseInt(txtMes.getText()) % 2 == 0) {
								expectedMaxDay = 30;
							} else {
								expectedMaxDay = 31;
							}
							
							if(Integer.parseInt(txtDia.getText()) <= expectedMaxDay && (Integer.parseInt(txtDia.getText()) % 1) == 0) {
								dia = true;
							} else {
								errors[1] = true;
							}
						} else {
							errors[1] = true;
						}
						
						
					}
					if(errors[1]) {
						if(mes) {
							JOptionPane.showMessageDialog(null, "El dia es incorrecto, tiene que ser un numero entero menor a 28, 30 o 31 dependiendo del mes");
							
						} else {
							JOptionPane.showMessageDialog(null, "El dia no se puede evaluar hasta tener un mes correcto");
						}
					}
					
					//cambiar color del borde a lo que esta mal
					for(int i = 0; i<4; i++) {
						if(errors[i]) {
							((JComponent) errorsComp[i]).setBorder(new LineBorder(Color.RED,1));
						} else {
							((JComponent) errorsComp[i]).setBorder(new LineBorder(Color.GRAY,1));
						}
					}
					
					//cuando todo esta bien se ejecuta esto para ahora si añadir el pedido
					if(!errors[0] && dia && mes && year) {
						String newDate = txtMes.getText() + "/" + txtDia.getText() + "/" + txtAnio.getText();
						String tipo;
						
						if(tallerRadio.isSelected()) {
							tipo = "Taller";
						} else {
							tipo = "Traspaso";
						}
						
						int epoch = 0;
						
						try {
							epoch = (int) (new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(newDate+" 01:00:00").getTime() / 1000);
						} catch (ParseException e1) {
							//catch por si acaso (no se necesita realmente)
						}
						
						listaPedidos pedido = new listaPedidos();
						boolean added = pedido.add(tipo, txtCodigo.getText(), deBox.getSelectedItem().toString(), paraBox.getSelectedItem().toString(), String.valueOf(epoch));
						
						if(added) {
							JOptionPane.showMessageDialog(null, "Pedido añadido exitosamente");
							dispose();
							Message msg = new Message();
							msg.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "No se pudo agregar el pedido");
						}
					}
				}
				
					
			}
		});
	}

	
	
	public void Cursor(Component objeto) {
		objeto.addMouseMotionListener(new MouseMotionListener() {
		    @Override
		    public void mouseMoved(MouseEvent e) {
		    	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		    	setCursor(cursor);
		    }

		    //metodo innecesario
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
