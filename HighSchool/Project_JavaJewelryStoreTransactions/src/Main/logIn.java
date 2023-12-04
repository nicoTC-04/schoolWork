package Main;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class logIn {

	private JFrame frame;
	private JTextField txtPassword;
	private boolean Check;
	private String Show;
	
	//variable para leer el xml de la contraseña
	private Password Psswrd = new Password();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logIn window = new logIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public logIn() {
		initialize();
	}


	private void initialize() {
		
		//Iniciar Jframe
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(UIManager.getColor("Button.light"));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("recursos\\Icon.png"));
		frame.setBounds(400, 50, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.toBack();
		
		//cambair el cursor en el frame
		frame.addMouseMotionListener(new MouseMotionListener() {
		    @Override
		    public void mouseMoved(MouseEvent e) {
		    	Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
		    	frame.setCursor(cursor);	
		    }
		    
		    //metodo Obligatorio que no importa
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//Label donde dice LogIn
		JLabel lblLogIn = new JLabel("LogIn");
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setVerticalAlignment(SwingConstants.TOP);
		lblLogIn.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblLogIn.setBounds(191, 243, 63, 33);
		frame.getContentPane().add(lblLogIn);
		
		//TextField para insertar la contraseña
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtPassword.setText("Enter Password");
		txtPassword.setBounds(157, 287, 127, 23);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		//Label para logo de la joyeria
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon("recursos\\Logo.png"));
		lblLogo.setBounds(59, 18, 300, 145);
		frame.getContentPane().add(lblLogo);
		
		//Botón para confirmar contraseña
		JButton btnAccept = new JButton("Accept");
		btnAccept.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAccept.setBounds(175, 337, 89, 23);
		frame.getContentPane().add(btnAccept);
		
		//MouseListener para cambiar el cursor
		btnAccept.addMouseMotionListener(new MouseMotionListener() {
		    @Override
		    public void mouseMoved(MouseEvent e) {
		    	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		    	frame.setCursor(cursor);
		    }

		    //metodo innecesario
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//Accion que se produce al hacer click en el boton de Accept
		btnAccept.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Check = Psswrd.passwordCheck(txtPassword.getText());
					if(Check) {
						Show = "Bienvenido!";
						frame.dispose();
						Message msg = new Message();
						msg.setVisible(true);
					} else {
						Show = "La contraseña es incorrecta";
					}
					JOptionPane.showMessageDialog(null, Show);
				} catch(Exception j){
					JOptionPane.showMessageDialog(null, j);
				}
			}
		});
	}
}
